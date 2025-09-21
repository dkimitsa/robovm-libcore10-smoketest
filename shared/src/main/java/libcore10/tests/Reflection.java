package libcore10.tests;

import java.lang.reflect.Method;

/**
 * Tests reflection related API added in
 */
public class Reflection {

    interface Foo {
        default int test1() {
            return 1;
        }
        default int test2() {
            return 2;
        }
    }
    static class FooImpl implements Foo{
        @Override
        public int test2() {
            return 3;
        }
    }

    /**
     * tests reflection added APIs:
     * - Method.isDefault()
     */
    public static void test() {
        Method test1;
        Method test2;
        try {
            test1 = FooImpl.class.getMethod("test1");
            test2 =FooImpl.class.getMethod("test2");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println("test1.isDefault() = " + test1.isDefault());
        System.out.println("test2.isDefault() = " + test2.isDefault());
        if (!test1.isDefault()) throw new Error();
        if (test2.isDefault()) throw new Error();
    }
}
