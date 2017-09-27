package me.dev1001.examples.lang;

/**
 * @author hongzong.li
 */
public class OverrideFiledExample {

    public static void main(String[] args) {
        Sub sub = new Sub();

        Base base = sub;
        System.out.println(base.getI());

        System.out.println(sub.getI());
        System.out.println(sub.getBaseI());
    }

    private static class Sub extends Base {

        int i = 5;

        @Override
        public int getI() {
            return i;
        }

        public int getBaseI() {
            return super.i;
        }


    }
    private static class Base {
        int i = 3;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
