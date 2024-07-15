package rssfeedexample;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Enter RSS feed URLs (type 'done' to finish): ");
        String url;
        while (!(url = scanner.nextLine()).equalsIgnoreCase("done")) {
            executorService.execute(new RSSFeedChecker(url, 60000));
        }

        System.out.println("RSS Feed Checkers are running. Type 'exit' to stop all feeds and exit the program.");

        while (!scanner.nextLine().trim().equalsIgnoreCase("exit")) {
            System.out.println("Type 'exit' to stop all feeds and exit the program.");
        }

        shutdownAndAwaitTermination(executorService);
    }

    private static void shutdownAndAwaitTermination(ExecutorService pool) {
        System.out.println("Shutdown initiated, waiting for tasks to complete...");
        for (int i = 0; i < 60; i++) {
            if (pool.isTerminated()) {
                System.out.println("All tasks have completed.");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("Timeout reached before termination, forcing shutdown...");
        pool.shutdownNow();
        if (pool.isTerminated()) {
            System.out.println("All tasks were terminated successfully after force shutdown.");
        } else {
            System.err.println("Some tasks may still be running.");
        }
    }
}
