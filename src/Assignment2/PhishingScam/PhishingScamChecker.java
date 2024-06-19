package Assignment2.PhishingScam;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
public class PhishingScamChecker {
        public static void checkScamScore(String filePath) {
            List<String> mildThreats = loadMildThreats();
            List<String> moderateThreats = loadModerateThreats();
            List<String> likelyThreats = loadLikelyThreats();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int totalPoints = 0;
                while ((line = br.readLine()) != null) {
                    for (String threat : mildThreats) {
                        int occurrences = countOccurrences(line.toLowerCase(), threat.toLowerCase());
                        if (occurrences > 0) {
                            totalPoints += occurrences;
                        }
                    }
                    for (String threat : moderateThreats) {
                        int occurrences = countOccurrences(line.toLowerCase(), threat.toLowerCase());
                        if (occurrences > 0) {
                            totalPoints += 2 * occurrences;
                        }
                    }
                    for (String threat : likelyThreats) {
                        int occurrences = countOccurrences(line.toLowerCase(), threat.toLowerCase());
                        if (occurrences > 0) {
                            totalPoints += 3 * occurrences;
                        }
                    }
                }
                System.out.println("Total Points for the Entire Message: " + totalPoints);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private static int countOccurrences(String text, String keyword) {
            int count = 0;
            int index = 0;
            while ((index = text.indexOf(keyword, index)) != -1) {
                count++;
                index += keyword.length();
            }
            return count;
        }

        private static List<String> loadMildThreats() {
            List<String> mildThreats = new ArrayList<>();
            mildThreats.add("Password");
            mildThreats.add("Account");
            mildThreats.add("Login");
            mildThreats.add("Security");
            mildThreats.add("Verify");
            mildThreats.add("Free");
            mildThreats.add("Alert");
            mildThreats.add("Win");
            mildThreats.add("Winner");
            mildThreats.add("Claim");
            return mildThreats;
        }

        private static List<String> loadModerateThreats() {
            List<String> moderateThreats = new ArrayList<>();
            moderateThreats.add("Your account has been compromised");
            moderateThreats.add("Urgent action required");
            moderateThreats.add("Verify your account information");
            moderateThreats.add("Security breach detected");
            moderateThreats.add("Update your login details");
            moderateThreats.add("Suspicious activity detected");
            moderateThreats.add("Unauthorized access attempted");
            moderateThreats.add("Immediate attention required");
            moderateThreats.add("Confirm your identity");
            moderateThreats.add("Important security alert");
            return moderateThreats;
        }

        private static List<String> loadLikelyThreats() {
            List<String> likelyThreats = new ArrayList<>();
            likelyThreats.add("PayPal");
            likelyThreats.add("Google");
            likelyThreats.add("Microsoft");
            likelyThreats.add("Apple");
            likelyThreats.add("Amazon");
            likelyThreats.add("eBay");
            likelyThreats.add("Facebook");
            likelyThreats.add("Netflix");
            likelyThreats.add("Bank of America");
            likelyThreats.add("Wells Fargo");
            return likelyThreats;
        }

    }


