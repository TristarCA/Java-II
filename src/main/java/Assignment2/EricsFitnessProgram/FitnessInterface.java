package Assignment2.EricsFitnessProgram;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class FitnessInterface {
    public static void main(String[] args) {
        String filePath = "./settings.xml";
        Path path = Paths.get(filePath);
        Settings settings = new Settings();
        if (Files.exists(path)) {
            System.out.println("Exists!");
        } else {
            try (BufferedWriter output = Files.newBufferedWriter(path)) {
                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to Eric's Fitness Program!\nLet's get Started with your name!\nName: ");
                String name = input.nextLine();
                System.out.printf("Hello %s, Can we please get your Height in cm:\n", name);
                int height = input.nextInt();
                System.out.println("Very good! Can we also get your weight in lbs:");
                int weight = input.nextInt();
                System.out.printf("Ok %s, next please input your birth year:\n", name);
                int year = input.nextInt();
                System.out.println("Month:");
                int month = input.nextInt();
                System.out.println("Day:");
                int day = input.nextInt();
                LocalDate birthday = LocalDate.of(year, month, day);
                System.out.println("Finally we'll need your functional threshold power... Let's assume that to be a float!\nFTP:");
                float ftp = input.nextFloat();
                FitnessProgramSettings userSettings = new FitnessProgramSettings(name, height, weight, birthday, ftp);
                settings.getSettings().add(userSettings);
                JAXB.marshal(settings, output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
