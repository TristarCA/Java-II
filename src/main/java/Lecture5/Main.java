package Lecture5;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalGuesses = 0;
        System.out.println("Selecting a number from 1-100");
        NumberGenerator generator = new NumberGenerator();
        int choice = generator.numberSelector();
        System.out.println("Ok go ahead and guess: ");
        int selection = input.nextInt();

        try (Formatter output = new Formatter("gamelog.txt")) {
            while (selection != choice) {
                output.format("%d%n", selection);
                System.out.println("You have entered " + selection);
                if (selection < choice) {
                    System.out.println("That's too low sorry\n");
                    totalGuesses++;
                }
                else  {
                    System.out.println("That's too high sorry\n");
                    totalGuesses++;
                }
                System.out.println("Select a new number");
                selection = input.nextInt();
            }
            output.format("%d%n", selection);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        totalGuesses++;
        System.out.printf("You got it the number was %d Goodbye! It took %d tries", choice, totalGuesses);
    }
}
