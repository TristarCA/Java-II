package June10Review;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidation {
    public static void validateNumber() {
        ArrayList<String> validationList = new ArrayList<>();
        String filePath = "./src/main/java/June10Review/contacts.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                validationList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern expression = Pattern.compile("^\\w+\\s+\\w+\\s+(709|613)-[0-9]{3}-[0-9]{4}");
        try (Formatter incorrectFormatter = new Formatter(new FileOutputStream("./src/main/java/June10Review/incorrectContacts.txt"));
            Formatter correctFormatter = new Formatter (new FileOutputStream("./src/main/java/June10Review/correctContacts.txt"))) {
            for (String contact : validationList) {
                Matcher matcher = expression.matcher(contact);
                if (!matcher.find()) {
                    incorrectFormatter.format("%s%n", contact);
                } else {
                    correctFormatter.format("%s%n", contact);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
