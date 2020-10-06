package libcore10.tests;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/**
 * Testing Conscrypt + BoringSSL + okhttp
 */
public final class Https {
    public static void test_Https() throws IOException, JSONException {
        //https://gitter.im/MobiVM/robovm?at=5ef1d3c7c223cc536a2e4a32
        URL url = new URL("https://www.howsmyssl.com/a/check");
        URLConnection conn = url.openConnection();
        String response;
        try (InputStream in = conn.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            response = reader.lines().collect(Collectors.joining());
        }

        JSONObject o = new JSONObject(response);
        System.out.println(o.toString(2));
    }

    public static void test() throws IOException, JSONException {
        test_Https();
    }
}
