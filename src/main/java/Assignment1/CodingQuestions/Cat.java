package Assignment1.CodingQuestions;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cat {
    public static void cat(File file) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            cat(file);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
