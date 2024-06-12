package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Redaction {
    public static void redactInformation() {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> potentialRedactions = new ArrayList<>();
        String filePath = "./src/main/java/Assignment3/sampleInfo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                potentialRedactions.add(line);
            }
            for (String potentialRedaction : potentialRedactions) {
                redactionCheck(potentialRedaction, builder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Formatter formatter = new Formatter(new FileOutputStream("./src/main/java/Assignment3/sampleInfoRedacted.txt"))) {
            for (String line : builder.toString().split("\n")) {
                System.out.println(line);
                formatter.format("%s%n", line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void redactionCheck(String potentialRedaction, StringBuilder builder) {
        for (char c : potentialRedaction.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append('#');
            } else  {
                builder.append(c);
            }
        }
        builder.append("\n");

    }
}
