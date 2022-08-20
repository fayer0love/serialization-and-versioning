import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Base64;

public class VersioningTest  {

    public VersioningTest() {
    }

    @Test
    public void serializationTest() throws Exception {
        Product product = new Product("Ader Error", "XL");
        String serializedObj = serializeObjectToString(product);
        System.out.println("Serialized Product object to String:");
        System.out.println(serializedObj);
    }

    @Test
    public void deserializationTest() throws Exception {
        String serializedObj = "rO0ABXNyAAdQcm9kdWN0AAAAAAC8YU4CAAJMAARuYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7TAAEc2l6ZXEAfgABeHB0AApBZGVyIEVycm9ydAACWEw";
        System.out.println("Deserializing Product ... ");
        Product deserializedObj = (Product)this.deserializeObjectFromString(serializedObj);
        System.out.println(deserializedObj.toString());
    }

    private static String serializeObjectToString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    private Object deserializeObjectFromString(String serializedObj) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(serializedObj);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}