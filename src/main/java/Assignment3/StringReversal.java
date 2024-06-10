package Assignment3;

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        String[] tokens = s.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            System.out.println(tokens[i]);
        }
    }
}
