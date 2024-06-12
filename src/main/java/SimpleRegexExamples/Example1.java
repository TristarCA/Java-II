package SimpleRegexExamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {

        Pattern expression = Pattern.compile("\\w*abcd");

        String name = "abcdefghijkabcd";

        Matcher matcher = expression.matcher(name);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
        //String regex = "[A-Za-z]{7}\\s?[A-Za-z]+";
        //String regex = "[A-Za-z]+\\s[A-Za-z]+";

        //String regex = "Hi (Tristan|Norman)";

        System.out.println(matcher.matches());
        //System.out.println(name2.matches(regex));
    }
}
