package Test1Practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringManipulation {
    public static void main(String[] args) throws InvalidPhoneNumberFormatException {
        Pattern phonePattern = Pattern.compile("^\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a vail phone number in the form (xxx) xxx-xxxx");
        String phoneNumber = input.nextLine();
        Matcher matcher = phonePattern.matcher(phoneNumber);
        if (matcher.matches()) {
            System.out.println("Match found!");
        } else {
            throw new InvalidPhoneNumberFormatException("Please make sure to input a number in the format suggested!");
        }

    }
}
