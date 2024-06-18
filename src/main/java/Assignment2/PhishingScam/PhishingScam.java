package Assignment2.PhishingScam;

import java.util.Scanner;
public class PhishingScam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the path to your potential scam email: ");
        String filePath = "./email.txt";
        PhishingScamChecker.checkScamScore(filePath);
    }
}
