package SimpleRegexExamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {
        // Example 1: Find all words ending with 'abcd'
        Pattern expression1 = Pattern.compile("\\w*abcd");
        String text1 = "abcdefghijkabcd";
        Matcher matcher1 = expression1.matcher(text1);

        System.out.println("Example 1: Words ending with 'abcd'");
        while(matcher1.find()) {
            System.out.println(matcher1.group());
        }

        // Example 2: Check if the entire string matches a pattern (7 letters followed by optional space and more letters)
        String regex2 = "[A-Za-z]{7}\\s?[A-Za-z]+";
        String text2 = "Example abcdefg";
        String secondExample = "ExampleabcdefgWithoutSpace";
        boolean matches2 = text2.matches(regex2);
        boolean matchesSecond = secondExample.matches(regex2);
        System.out.println("\nExample 2: Matches pattern '[A-Za-z]{7}\\s?[A-Za-z]+'");
        System.out.println("Text: " + text2 + " -> " + matches2);
        System.out.println("This also matches! Text: " + secondExample + " -> " + matchesSecond);

        // Example 3: Find all words consisting of two words separated by a space
        String regex3 = "(?=\\w+\\s)\\w+\\s\\w+(?=\\s\\w+|$)";
        String text3 = "Hello World Java Regex";
        Pattern expression3 = Pattern.compile(regex3);
        Matcher matcher3 = expression3.matcher(text3);

        System.out.println("\nExample 3: Words consisting of two words separated by a space");
        while(matcher3.find()) {
            System.out.println(matcher3.group());
        }

        // Example 4: Match specific names
        String regex4 = "Hi (Tristan|Norman)";
        String text4 = "Hi Dave";
        boolean matches4 = text4.matches(regex4);
        System.out.println("\nExample 4: Matches pattern 'Hi (Tristan|Norman)'");
        System.out.println("Text: " + text4 + " -> " + matches4);

        // Additional example: Find all occurrences of a pattern in a string
        String text5 = "Hello abcdefghijkabcd world abcd";
        Pattern expression5 = Pattern.compile("\\w*abcd");
        Matcher matcher5 = expression5.matcher(text5);

        System.out.println("\nAdditional Example: Find all occurrences of a pattern '\\w*abcd' in a string");
        while(matcher5.find()) {
            System.out.println(matcher5.group());
        }
    }
}
