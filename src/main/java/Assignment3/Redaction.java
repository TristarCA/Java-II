package Assignment3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redaction {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\b\\d{2}-\\d{2}-\\d{2,4}\\b");
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{4}-\\d{4}\\b");
    private static final Pattern CURRENCY_PATTERN = Pattern.compile("\\$\\d+(\\.\\d{2})?");
    private static final Pattern SECURITY_CODE_PATTERN = Pattern.compile("\\bCODE\\d{16}\\b*");

    public static void redactInformation() {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/Assignment3/sampleInfo.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/Assignment3/sampleInfoRedacted.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(redactLine(line));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String redactLine(String line) {
        Matcher matcher;

        matcher = DATE_PATTERN.matcher(line);
        if (matcher.find()) {
            line = replacePattern(line, DATE_PATTERN, "##-##-####");
        }

        matcher = CREDIT_CARD_PATTERN.matcher(line);
        if (matcher.find()) {
            line = replacePattern(line, CREDIT_CARD_PATTERN, "####-####-####-####");
        }

        matcher = CURRENCY_PATTERN.matcher(line);
        if (matcher.find() && line.length() >= 4) {
            String currencyValue = matcher.group();
            line = replacePattern(line, CURRENCY_PATTERN, "$" + "#".repeat(currencyValue.length() - 4) + ".##");
        }

        matcher = SECURITY_CODE_PATTERN.matcher(line);
        if (matcher.find()) {
            line = replacePattern(line, SECURITY_CODE_PATTERN, "CODE################");
        }

        return line;
    }


    private static String replacePattern(String line, Pattern pattern, String replacement) {
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll(Matcher.quoteReplacement(replacement));
    }
}
