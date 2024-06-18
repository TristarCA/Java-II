package Test1Practice;

import java.io.*;
import java.util.Scanner;

public class PerplexityFileExample {
    public static void main(String[] args) throws InvalidFileException {
        File inputFile = new File("./src/main/java/Test1Practice/input.txt");
        File outputFile = new File("./src/main/java/Test1Practice/uotput.txt");
        if (!inputFile.exists()) {
            throw new InvalidFileException("This file you are attempting to use does not exist");
        }

        try (Scanner reader = new Scanner(inputFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
