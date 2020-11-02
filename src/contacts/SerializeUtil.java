package contacts;

import java.io.*;
import java.util.List;

public class SerializeUtil {
    //deserilalize
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bif = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bif);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
//serializing
    public static void seialize(List<AllRecords> records, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream oos = new ObjectOutputStream(bufferedOutputStream);
            oos.writeObject(records);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
