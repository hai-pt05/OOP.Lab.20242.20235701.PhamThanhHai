package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; // Thay bằng đường dẫn tới tệp lớn
        long start = System.currentTimeMillis();
        String output = "";

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            for (byte b : inputBytes) {
                output += (char) b; // Nối chuỗi bằng toán tử +
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
        // System.out.println("Output length: " + output.length()); // Kiểm tra độ dài chuỗi
    }
}