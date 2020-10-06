package libcore10.tests;

import java.net.IDN;
import java.text.Collator;
import java.util.Locale;

/**
 * testing icu4j/icu4c code
 */
public class ICU {
    public static void  test_rfc3490() {
        // https://github.com/MobiVM/robovm/issues/86
        IDN.toASCII("https://www.google.com");
    }

    public static void test_collator() {
        Collator.getInstance(Locale.US);
    }

    public static void testLocale() {
        String.format(Locale.CANADA_FRENCH, "%s locale", "hello");
    }

    public static void test() {
        test_rfc3490();
        test_collator();
        testLocale();
    }
}
