package rssfeedexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> feedUrls = new ArrayList<>();
        final String end = "done";
        String url = "";

        System.out.println("Enter RSS feed URLs (type 'done' to finish): ");
        while(!url.equals(end)) {
            url = scanner.nextLine();
            if (!url.equalsIgnoreCase(end)) {
                feedUrls.add(url);
            }

        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String feedUrl : feedUrls) {
            RSSFeedChecker checker = new RSSFeedChecker(feedUrl);
            executorService.execute(checker);
            executorService.shutdown();
        }
    }
}
