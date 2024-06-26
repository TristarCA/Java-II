package May27Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.bind.JAXB;

public class AnalyzeLogs {
    public static void main(String[] args) {
        Path path = Paths.get("./logs");
        if (Files.exists(path))
        {
            System.out.println("Folder exists");

            try {
                DirectoryStream<Path> directoryStream =
                        Files.newDirectoryStream(path);
                int totalFiles = 0;
                int totalGuesses = 0;
                for (Path p : directoryStream) {
                    totalFiles++;
                    System.out.println(p);
                    Scanner input = new Scanner(p);
                    while( input.hasNext() ) {
                        //try(BufferedReader num = Files.newBufferedReader(Paths.get("")))
                        totalGuesses++;
                        String line = input.nextLine();
                        System.out.println(line);
                    }
                }
                System.out.println("Total guesses " + totalGuesses);
                System.out.println("Total files " + totalFiles);
                System.out.println("Average guesses: " + (float)totalGuesses/totalFiles);
            }
            catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
        else {
            System.out.println("Can't find folder to process logs");
        }


    }
}
