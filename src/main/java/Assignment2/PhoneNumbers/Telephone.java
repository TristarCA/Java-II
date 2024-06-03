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

        try (Formatter formatter = new Formatter(new FileOutputStream("potentialWords.txt"))) {
            for (String combination : combinations) {
                formatter.format("%s%n", combination);
            }
            System.out.println("Combinations written to potentialWords.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 7) {
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (c < '2' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
