package Test1Practice;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnotherFilePractice {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("old");
        Pattern codePattern = Pattern.compile("CODE\\d{16}");
        Date date = new Date();
        long timeStamp = date.getTime();
        File oldFile = new File("./src/main/java/Test1Practice/sampleInfo.txt");
        File newFile = new File("./src/main/java/Test1Practice/newFile" + timeStamp + ".txt");
        try (Scanner reader = new Scanner(oldFile);
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            while (reader.hasNext()) {
                String line  = reader.nextLine();
                StringBuilder processedCode = new StringBuilder();
                Matcher matcher = pattern.matcher(line);
                Matcher codeMatcher = codePattern.matcher(line);
                if (matcher.find()) {
                    String old = matcher.group();
                    String notOld = "new";
                     line = line.replace(old, notOld);
                }
                if (codeMatcher.find()) {
                    String code = codeMatcher.group();
                    for (char ch : code.toCharArray()) {
                        if (Character.isDigit(ch)) {
                            processedCode.append("#");
                        } else {
                            processedCode.append(ch);
                        }
                    }
                    line = line.replace(code, processedCode.toString());
                }
                writer.write(line);
                writer.newLine();
            }
        //} //catch (InvalidFileException e) {
         //   throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
}
