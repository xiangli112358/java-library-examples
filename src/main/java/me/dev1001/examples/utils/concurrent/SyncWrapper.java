package me.dev1001.examples.utils.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.google.common.base.Preconditions.checkState;

/**
 * @author hongzong.li
 */
public class SyncWrapper<T> {
    private final CountDownLatch latch = new CountDownLatch(1);

    private final AtomicBoolean hasResult = new AtomicBoolean(false);

    private volatile T value;

    private volatile Throwable exception;

    private final Runnable asyncTask;

    private SyncWrapper(Runnable asyncTask) {
        this.asyncTask = asyncTask;
    }

    public static <T> SyncWrapper<T> wrap(Runnable asyncTask) {
        return new SyncWrapper<>(asyncTask);
    }

    public T sync() throws ExecutionException {
        asyncTask.run();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Sync thread interrupted unexpectedly", e);
        }
        if (exception != null) {
            throw new ExecutionException(exception);
        }
        return value;
    }

    public final void setValue(T value) {
        checkState(!hasResult.get(), "result already set");
        if (hasResult.compareAndSet(false, true)) {
            this.value = value;
            release();
        }
    }


    public final void setException(Throwable exception) {
        checkState(!hasResult.get(), "result already set");
        if (hasResult.compareAndSet(false, true)) {
            this.exception = exception;
            release();
        }
    }

    private void release() {
        latch.countDown();
    }

}
