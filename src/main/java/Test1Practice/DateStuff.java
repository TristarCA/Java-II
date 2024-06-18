package Test1Practice;

/** Write a Java program that prompts the user to enter a string representing a date in the format "MM/DD/YYYY".
*  Use regular expressions to validate the input string and ensure that the date is valid
* (e.g., month between 1 and 12, day between 1 and 31 based on the month, and a valid year).
* If the input is invalid, throw a custom exception called InvalidDateFormatException.
* If the input is valid, extract the month, day, and year components from the string and print them separately.
 * */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateStuff {

    public static void main(String[] args) throws InvalidDateFormatException {
        Pattern pattern = Pattern.compile("^(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/\\d{4}$");
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a date in the format 'MM/DD/YYYY'");
        String date = input.nextLine();
        Matcher matcher = pattern.matcher(date);
        if (!matcher.matches()) {
            throw new InvalidDateFormatException("Incorrect date format please try again!");
        } else {
            char[] data = date.toCharArray();
            System.out.println("Month: " + data[0] + data[1]);
            System.out.println("Day: " + data[3] + data[4]);
            System.out.println("Year: " + data[6] +data[7]+data[8]+data[9]);
        }

    }
}
