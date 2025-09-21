package libcore10.tests;

import java.io.*;

public class ObjectStream {
    public static class One {
        public final int a;
        public final int b;
        public One() {
            a = 1;
            b = 2;
        }
    }
    public static class Two extends One implements Serializable {
        int c;
        int d;
    }


    /**
     * tests Constructor.serializationCopy required for ObjectInputStream
     */
    public static void test() {
        Two sendable = new Two();
        sendable.c = 3;
        sendable.d = 4;

        Two receivable;
        try {
            ObjectOutputStream out = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(baos);
            out.writeObject(sendable);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            receivable = (Two) in.readObject();
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (receivable.a != 1 || receivable.b != 2 || receivable.c != 3 || receivable.d != 4)
            throw new Error("Failed");
    }
}
