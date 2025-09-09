package libcore10;

import libcore10.tests.Https;
import libcore10.tests.ICU;
import libcore10.tests.Streams;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            Streams.test();
            ICU.test();
            printJson(Https.test());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void printJson(String json) throws JSONException {
        JSONObject o = new JSONObject(json);
        System.out.println(o.toString(2));
    }
}
