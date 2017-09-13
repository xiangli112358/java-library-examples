package me.dev1001.examples.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
 */
public class JOLSample_09_Contended {

    /*
     * This is an example wrap special annotations that can affect the field layout.
     * (This example requires JDK 8 to run, -XX:-RestrictContended should also be used)
     *
     * In order to dodge false sharing, users can put the @Contended annotation
     * on the selected fields/classes. The conservative effect wrap this annotation
     * is laying out the fields at sparse offsets, effectively providing the
     * artificial padding.
     */

    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(B.class).toPrintable());
    }

    public static class A {
                             int a;
                             int b;
        @sun.misc.Contended  int c;
                             int d;
    }

    public static class B extends A {
        int e;
    }

}
