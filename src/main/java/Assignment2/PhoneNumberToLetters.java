package Assignment2;

import java.util.ArrayList;

public class PhoneNumberToLetters {
    public String toLetters(String phoneNumber) {
        ArrayList<String> potentialString = new ArrayList<>();
        ArrayList<Character> phoneNumberChar = new ArrayList<>();
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            phoneNumberChar.add(ch);
        }
        int counter = 0;
            for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumberChar.get(i) == '2') {
                if (counter == 0) {
                    potentialString.add("A");
                    counter++;
                } else if (counter == 1 && phoneNumberChar.get(i-1) == '2') {
                    potentialString.add("B");
                    counter++;
                } else if (counter == 2 && phoneNumberChar.get(i-1) == '2') {
                    potentialString.add("C");
                    counter = 0;
                }
            }
            else if (phoneNumberChar.get(i) == '3') {
                if (counter == 0) {
                    potentialString.add("D");
                } else if (counter == 1) {
                    potentialString.add("E");
                } else {
                    potentialString.add("F");
                }
            } else if (phoneNumberChar.get(i) == '4') {
                if (counter == 0) {
                    potentialString.add("G");
                } else if (counter == 1) {
                    potentialString.add("H");
                } else {
                    potentialString.add("I");
                }
            } else if (phoneNumberChar.get(i) == '5') {
                if (counter == 0) {
                    potentialString.add("J");
                } else if (counter == 1) {
                    potentialString.add("K");
                } else {
                    potentialString.add("L");
                }
            } else if (phoneNumberChar.get(i) == '6') {
                if (counter == 0) {
                    potentialString.add("M");
                } else if (counter == 1) {
                    potentialString.add("N");
                } else {
                    potentialString.add("O");
                }
            } else if (phoneNumberChar.get(i) == '7') {
                if (counter == 0) {
                    potentialString.add("P");
                } else if (counter == 1) {
                    potentialString.add("R");
                } else {
                    potentialString.add("S");
                }
            } else if (phoneNumberChar.get(i) == '8') {
                if (counter == 0) {
                    potentialString.add("T");
                } else if (counter == 1) {
                    potentialString.add("U");
                } else {
                    potentialString.add("V");
                }
            } else if (phoneNumberChar.get(i) == '9') {
                if (counter == 0) {
                    potentialString.add("W");
                } else if (counter == 1) {
                    potentialString.add("X");
                } else {
                    potentialString.add("Y");
                }
            }
        }
        System.out.println(potentialString);
        return "Oifdg";
    }
}
