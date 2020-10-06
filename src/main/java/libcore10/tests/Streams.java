package libcore10.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Testing streams availability
 */
public final class Streams {
    public static void test_basicStream() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public static void test() {
        test_basicStream();
    }
}
