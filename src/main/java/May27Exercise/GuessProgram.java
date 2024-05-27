package May27Exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.bind.JAXB;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Date;

public class GuessProgram {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        Long timestamp = date.getTime();
        Numbers numbers = new Numbers();

        try(BufferedWriter output = Files.newBufferedWriter(Paths.get("./logs/gamelog"+timestamp+".txt"))) {
            int correct = rand.nextInt( 1, 100);
            int guess = -99;
            int totalGuesses = 0;
            while( correct != guess ) {

                if( totalGuesses > 0) {
                    if( guess > correct ) {
                        Guess userGuess = new Guess(guess);
                        numbers.getGuesses().add(userGuess);
                        System.out.println("Too high");
                    }
                    else {
                        Guess userGuess = new Guess(guess);
                        numbers.getGuesses().add(userGuess);
                        System.out.println("Too low");
                    }
                }
                System.out.println("Guess number between 1 and 100");
                try {
                    guess = input.nextInt();
                    totalGuesses++;
                }
                catch( NoSuchElementException e) {
                    System.out.println("You entered an invalid number, try again");
                    input.next();
                }
            }
            System.out.println("You guessed " + correct + " It took you " + totalGuesses + " guesses");
            JAXB.marshal(numbers, output);
        }
        catch( FileNotFoundException | SecurityException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
