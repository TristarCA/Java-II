package Assignment2.PhoneNumbers;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberToLetters {
    public List<String> toLetters(String phoneNumber) {
        List<String> results = new ArrayList<>();
        generateCombinations(results, new StringBuilder(), phoneNumber, 0);
        return results;
    }

    private void generateCombinations(List<String> results, StringBuilder currentCombination, String phoneNumber, int currentIndex) {
        if (currentIndex == phoneNumber.length()) {
            results.add(currentCombination.toString());
            return;
        }

        char digit = phoneNumber.charAt(currentIndex);

        String letters;
        if (digit == '2') {
            letters = "ABC";
        } else if (digit == '3') {
            letters = "DEF";
        } else if (digit == '4') {
            letters = "GHI";
        } else if (digit == '5') {
            letters = "JKL";
        } else if (digit == '6') {
            letters = "MNO";
        } else if (digit == '7') {
            letters = "PRS";
        } else if (digit == '8') {
            letters = "TUV";
        } else if (digit == '9') {
            letters = "WXY";
        } else {
            generateCombinations(results, currentCombination, phoneNumber, currentIndex + 1);
            return;
        }

        for (char letter : letters.toCharArray()) {
            // for each character in the associated "letters" String
            currentCombination.append(letter);
            //append the letter to the 'currentCombination' StringBuilder
            generateCombinations(results, currentCombination, phoneNumber, currentIndex + 1);
            //continue on to the next number in the sequence
            currentCombination.deleteCharAt(currentCombination.length() - 1);
            //when we arrive at the final number our line 14 condition goes off and produces a String for our results list
            //that is when we arrive at this line of code which removes the final letter in the sequence, and we begin moving through
            //our potential outcomes.
        }
    }
}
