package Test1Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18");
        } else {
            System.out.println("Welcome!");
        }
    }

    public static void main(String[] args) throws InvalidAgeException {
        Scanner input = new Scanner(System.in);

        System.out.println("How old are you? ");

        try {
            int age = input.nextInt();
            assert age >= 0 : "Age cannot be a negative number";
            validateAge(age);
        } catch(InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            throw e;
        } catch (InputMismatchException e) {
            System.out.println("No oofs allowed bigot");
            input.nextLine();
        } finally {
            System.out.println("Try not to shit yourself");
        }
    }
}
