package me.dev1001.examples.utils.concurrent;

import java.util.concurrent.Callable;

public interface StripedCallable<V> extends Callable<V>,
    StripedObject {

}