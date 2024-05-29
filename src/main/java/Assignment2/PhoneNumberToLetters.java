package Assignment2;

import java.util.ArrayList;

public class PhoneNumberToLetters {
    public String toLetters(String phoneNumber) {
        int counter = 0;
        ArrayList<String> potentialString = new ArrayList<>();
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.toCharArray()[i] == '2') {
                if (counter == 0) {
                    potentialString.add("A");
                } else if (counter == 1) {
                    potentialString.add("B");
                } else {
                    potentialString.add("C");
                }
            } else if (phoneNumber.toCharArray()[i] == '3') {
                if (counter == 0) {
                    potentialString.add("D");
                } else if (counter == 1) {
                    potentialString.add("E");
                } else {
                    potentialString.add("F");
                }
            } else if (phoneNumber.toCharArray()[i] == '4') {
                if (counter == 0) {
                    potentialString.add("G");
                } else if (counter == 1) {
                    potentialString.add("H");
                } else {
                    potentialString.add("I");
                }
            } else if (phoneNumber.toCharArray()[i] == '5') {
                if (counter == 0) {
                    potentialString.add("J");
                } else if (counter == 1) {
                    potentialString.add("K");
                } else {
                    potentialString.add("L");
                }
            } else if (phoneNumber.toCharArray()[i] == '6') {
                if (counter == 0) {
                    potentialString.add("M");
                } else if (counter == 1) {
                    potentialString.add("N");
                } else {
                    potentialString.add("O");
                }
            } else if (phoneNumber.toCharArray()[i] == '7') {
                if (counter == 0) {
                    potentialString.add("P");
                } else if (counter == 1) {
                    potentialString.add("R");
                } else {
                    potentialString.add("S");
                }
            } else if (phoneNumber.toCharArray()[i] == '8') {
                if (counter == 0) {
                    potentialString.add("T");
                } else if (counter == 1) {
                    potentialString.add("U");
                } else {
                    potentialString.add("V");
                }
            } else if (phoneNumber.toCharArray()[i] == '9') {
                if (counter == 0) {
                    potentialString.add("W");
                } else if (counter == 1) {
                    potentialString.add("X");
                } else {
                    potentialString.add("Y");
                }
            }
            counter ++;
        }
        System.out.println(potentialString);
        return "Oifdg";
    }
}
