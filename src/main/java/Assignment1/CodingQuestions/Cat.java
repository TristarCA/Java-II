package Assignment1.CodingQuestions;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cat {
    public static void cat(File file){
        String line;
        try (RandomAccessFile input = new RandomAccessFile(file, "r")) {
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\tristan.norman\\Desktop\\cat.txt");
        cat(file);
    }
}
