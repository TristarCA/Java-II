package rssfeedexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

// May want to implement an RSSFeedApplication, RSSFeedCheckerRunnable(May already be complete with changes made to original RSSFeedChecker, and RSSItem class

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> feedUrls = new ArrayList<>();
        final String end = "done";
        String url = "";
        List<RSSItem> rssItems = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Enter RSS feed URLs (type 'done' to finish): ");
        while(!url.equals(end)) {
            url = scanner.nextLine();
            if (!url.equalsIgnoreCase(end)) {
                feedUrls.add(url);
            }
        }
        //executorService.execute(new RSSFeedChecker(url, rssItems, 1000)
        for (String feedUrl : feedUrls) {
            RSSFeedChecker checker = new RSSFeedChecker(feedUrl, 1000);
            executorService.execute(checker);
            executorService.shutdown();
        }
    }
}
