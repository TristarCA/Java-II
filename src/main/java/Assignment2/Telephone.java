package Assignment2;

import java.util.Scanner;

public class Telephone {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Telephone() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        this.phoneNumber = input.nextLine();
        System.out.println("Phone Number: " + phoneNumber);

    }

    public static void main(String[] args) {
        Telephone telephone = new Telephone();
        PhoneNumberToLetters phoneNumberToLetters = new PhoneNumberToLetters();
        phoneNumberToLetters.toLetters(telephone.phoneNumber);
    }
}
