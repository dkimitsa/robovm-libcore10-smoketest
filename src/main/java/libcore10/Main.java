package libcore10;

import libcore10.tests.Https;
import libcore10.tests.ICU;
import libcore10.tests.Streams;

public class Main {
    public static void main(String[] args) {
        try {
            Streams.test();
            ICU.test();
            Https.test();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
