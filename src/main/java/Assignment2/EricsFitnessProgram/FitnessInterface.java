package Assignment2.EricsFitnessProgram;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.xml.bind.*;

public class FitnessInterface {
    private static final String FILE_PATH = "./settings.xml";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Settings settings = new Settings();

        if (Files.exists(Paths.get(FILE_PATH))) {
            settings = loadSettings();
        }

        while (true) {
            displayMenu();
            int choice = getIntInput(input, "Invalid choice. Try again.");
            switch (choice) {
                case 1:
                    viewSettings(settings);
                    break;
                case 2:
                    updateSettings(settings, input);
                    saveSettings(settings);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. View Settings");
        System.out.println("2. Update Settings");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getIntInput(Scanner input, String errorMessage) {
        while (!input.hasNextInt()) {
            System.out.println(errorMessage);
            input.next();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    private static float getFloatInput(Scanner input, String errorMessage) {
        while (!input.hasNextFloat()) {
            System.out.println(errorMessage);
            input.next(); // clear invalid input
        }
        float value = input.nextFloat();
        input.nextLine(); // consume newline
        return value;
    }

    private static Settings loadSettings() {
        try {
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Settings settings = (Settings) unmarshaller.unmarshal(new File(FILE_PATH));
            return settings;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load settings.");
        }
    }

    private static void saveSettings(Settings settings) {
        try {
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(settings, new File(FILE_PATH));
            System.out.println("Settings saved successfully.");
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save settings.");
        }
    }

    private static void viewSettings(Settings settings) {
        if (settings.getSettings().isEmpty()) {
            System.out.println("No settings found. Please update your settings first.");
        } else {
            for (FitnessProgramSettings userSettings : settings.getSettings()) {
                System.out.println(userSettings);
            }
        }
    }

    private static void updateSettings(Settings settings, Scanner input) {
        System.out.println("Welcome to Eric's Fitness Program!\nLet's get Started with your name!\nName: ");
        String name = input.nextLine();

        int height = getPositiveInt(input, String.format("Hello %s, Can we please get your Height in cm: ", name));
        int weight = getPositiveInt(input, "Very good! Can we also get your weight in lbs: ");
        int year = getYear(input, String.format("Ok %s, next please input your birth year: ", name));
        int month = getMonth(input, "Month: ");
        int day = getDay(input, "Day: ");
        float ftp = getPositiveFloat(input, "Finally we'll need your functional threshold power: ");

        FitnessProgramSettings userSettings = new FitnessProgramSettings(name, height, weight, year, month, day, ftp);
        settings.getSettings().add(userSettings);
    }

    private static int getPositiveInt(Scanner input, String prompt) {
        int value;
        do {
            System.out.print(prompt);
            value = getIntInput(input, "Input must be a positive integer. Try again.");
        } while (value <= 0);
        return value;
    }

    private static float getPositiveFloat(Scanner input, String prompt) {
        float value;
        do {
            System.out.print(prompt);
            value = getFloatInput(input, "must be a positive value. Please try again.");
        } while (value <= 0);
        return value;
    }

    private static int getYear(Scanner input, String prompt) {
        int year;
        do {
            System.out.print(prompt);
            year = getIntInput(input, "Year must be between 1900 and 2100. Try again.");
        } while (year < 1900 || year > 2100);
        return year;
    }

    private static int getMonth(Scanner input, String prompt) {
        int month;
        do {
            System.out.print(prompt);
            month = getIntInput(input, "Month must be between 1 and 12. Try again.");
        } while (month < 1 || month > 12);
        return month;
    }

    private static int getDay(Scanner input, String prompt) {
        int day;
        do {
            System.out.print(prompt);
            day = getIntInput(input, "Day must be between 1 and 31. Try again.");
        } while (day < 1 || day > 31);
        return day;
    }
}