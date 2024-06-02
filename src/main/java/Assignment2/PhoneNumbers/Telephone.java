package Assignment2.PhoneNumbers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class Telephone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your 7 digit phone number: ");
        String phoneNumber = input.nextLine();
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number. Please enter a seven-digit number containing only digits 2-9.");
            return;
        }

        PhoneNumberToLetters converter = new PhoneNumberToLetters();
        List<String> combinations = converter.toLetters(phoneNumber);

        // Write the combinations to a file using Formatter.
        try (Formatter formatter = new Formatter(new FileOutputStream("potentialWords.txt"))) {
            for (String combination : combinations) {
                formatter.format("%s%n", combination);
            }
            System.out.println("Combinations written to potentialWords.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number is exactly 7 digits long and contains only digits 2-9
        return phoneNumber.length() == 7 && phoneNumber.matches("[2-9]+");
    }
}
