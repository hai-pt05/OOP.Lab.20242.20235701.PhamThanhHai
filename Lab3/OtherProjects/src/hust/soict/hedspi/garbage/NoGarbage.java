package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.exe";
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (int i = 0; i < inputBytes.length; i++) {
            outputStringBuilder.append((char) inputBytes[i]);
        }
        String output = outputStringBuilder.toString();
        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}