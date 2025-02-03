package projectonline;

import java.io.*;
import java.util.Map;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Save payment data to file
    public void savePaymentData(Map<String, String> paymentData) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(paymentData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load payment data from file
    public Map<String, String> loadPaymentData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

