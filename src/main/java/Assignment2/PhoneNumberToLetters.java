package Assignment2;

import java.util.ArrayList;

public class PhoneNumberToLetters {
    public void toLetters(String phoneNumber) {
        StringBuilder stringToAdd = new StringBuilder();
        ArrayList<Character> phoneNumberChar = new ArrayList<>();
        ArrayList<String> potentialString = new ArrayList<>();
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            phoneNumberChar.add(ch);
        }
        int counter = 0;
        do {
            for (int i = 0; i < phoneNumber.length(); i++) {
                System.out.print(phoneNumberChar.get(i));
                if (phoneNumberChar.get(i) == '2') {
                    if (counter == 0) {
                        stringToAdd.append("A");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i - 1) == '2') {
                        stringToAdd.append("B");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i - 1) == '2') {
                        stringToAdd.append("C");
                        counter = 0;
                    }
                }
                else if (phoneNumberChar.get(i) == '3') {
                    if (counter == 0) {
                        stringToAdd.append("D");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '3') {
                        stringToAdd.append("E");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '3') {
                        stringToAdd.append("F");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '3') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '4') {
                    if (counter == 0) {
                        stringToAdd.append("G");
                        counter++;
                    } else if (counter == 1 && (phoneNumberChar.get(i-1) == '4')) {
                        stringToAdd.append("H");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '4'){
                        stringToAdd.append("I");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '4') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '5') {
                    if (counter == 0) {
                        stringToAdd.append("J");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '5') {
                        stringToAdd.append("K");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '5') {
                        stringToAdd.append("L");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '5') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '6') {
                    if (counter == 0) {
                        stringToAdd.append("M");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '6') {
                        stringToAdd.append("N");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '6') {
                        stringToAdd.append("O");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '6') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '7') {
                    if (counter == 0) {
                        stringToAdd.append("P");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '7') {
                        stringToAdd.append("R");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '7') {
                        stringToAdd.append("S");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '7') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '8') {
                    if (counter == 0) {
                        stringToAdd.append("T");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '8') {
                        stringToAdd.append("U");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '8') {
                        stringToAdd.append("V");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '8') {
                        counter = 0;
                    }
                } else if (phoneNumberChar.get(i) == '9') {
                    if (counter == 0) {
                        stringToAdd.append("W");
                        counter++;
                    } else if (counter == 1 && phoneNumberChar.get(i-1) == '9') {
                        stringToAdd.append("X");
                        counter++;
                    } else if (counter == 2 && phoneNumberChar.get(i-1) == '9') {
                        stringToAdd.append("Y");
                        counter = 0;
                    }
                    if (counter == 1 && phoneNumberChar.get(i - 1) != '2') {
                        counter = 0;
                    }
                }

            }
            potentialString.add(stringToAdd.toString());
        }
        while (potentialString.size() < 45927);

        System.out.println(potentialString);
    }
}
