package Test1Practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class FileReaderPractice {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("CODE\\d+");
        Date date = new Date();
        long timestamp = date.getTime();
        int count = 0;
        File myFile = new File("./src/main/java/Test1Practice/sampleInfo.txt");
        File outputFile = new File("./src/main/java/Test1Practice/processedInfo" + timestamp + ".txt");

        try (Scanner myReader = new Scanner(myFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
             while (myReader.hasNextLine()) {
                 String data = myReader.nextLine();
                 System.out.println(data);


                 if (!data.isEmpty()) {
                     Matcher matcher = pattern.matcher(data);
                     if (matcher.find()) {
                         String foundCode = matcher.group();
                         StringBuilder processedCode = new StringBuilder();
                         for (char ch : foundCode.toCharArray()) {
                             if (Character.isDigit(ch)) {
                                 processedCode.append('#');
                             } else {
                                 processedCode.append(ch);
                             }
                         }
                         String processedData = data.replace(foundCode, processedCode.toString());
                         writer.write(processedData);
                         writer.newLine();
                         count++;
                     } else {
                         writer.write(data);
                         writer.newLine();
                         count++;
                     }
                 }
             }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file...");
            e.printStackTrace();
        }

        System.out.println("Number of non-empty lines: " + count);
    }
}
