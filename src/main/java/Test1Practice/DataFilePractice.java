package Test1Practice;

import java.io.*;
import java.util.Scanner;

public class DataFilePractice {
    public static void main(String[] args) throws InvalidFileException {
        File dataFile = new File("./src/main/java/Test1Practice/data.txt");
        if (!dataFile.exists()) {
            throw new InvalidFileException("The file you have requested does not exist!");
        }
        File outputFile = new File("./src/main/java/Test1Practice/output.txt");
        int count = 0;
        boolean blankCheck = false;
        try (Scanner readData = new Scanner(dataFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                while (readData.hasNextLine()) {
                    String toWrite = readData.nextLine();
                    if (toWrite.isEmpty()) {
                        writer.write("A BREAK HAS OCCURED HERE");
                        blankCheck = true;
                    }
                    count++;
                    writer.write(toWrite);
                    writer.newLine();
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Final line count: " + count);
            if (blankCheck) {
                throw new InvalidFileException("There is an empty line in the file and this is an issue please fix it.");
            }
        }
    }
}
