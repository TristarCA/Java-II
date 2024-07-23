package rssfeedexample;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The RSSFeedChecker class implements runnable and is responsible for periodically checking a list of RSS feeds for new articles.
 * It stores previously output articles and prints new ones after being checked against those that have be stored.
 */
public class RSSFeedChecker implements Runnable {
    private String feedUrl;
    private int sleep;
    private List<RSSItem> knownItems = new ArrayList<>();

    /**
     * Constructs an RSSFeedChecker with the specified feed URL and sleep interval
     * @param feedUrl: The URL of the RSS feed to be checked
     * @param sleep: The sleep interval between checks in milliseconds
     */
    public RSSFeedChecker(String feedUrl, int sleep) {
        this.feedUrl = feedUrl;
        this.sleep = sleep;
    }

    /**
     * The run method is called when the thread starts. It continuously checks the RSS feed at the specified interval until interrupted
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                checkFeed();
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("RSS feed checker interrupted during sleep. Exiting " + feedUrl);
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred in RSS feed checking: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Checks the RSS feed for new articles. If new articles are found, they are printed and added to the knownItems array.
     * If the article is already within the knownItems array it is not printed
     */
    private void checkFeed() {
        try {
            URL url = new URL(feedUrl);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            NodeList itemList = doc.getElementsByTagName("item");
            List<RSSItem> items = new ArrayList<>();

            boolean newArticleFound = false;
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;
                    RSSItem currItem = new RSSItem(
                            itemElement.getElementsByTagName("title").item(0).getTextContent(),
                            itemElement.getElementsByTagName("link").item(0).getTextContent(),
                            itemElement.getElementsByTagName("pubDate").item(0).getTextContent()
                    );

                    if (!knownItems.contains(currItem)) {
                        newArticleFound = true;
                        knownItems.add(currItem);
                        currItem.print(System.out);
                    }
                }
            }

            if (!newArticleFound) {
                System.out.println("No new articles have been posted to the RSS feed at " + feedUrl);
            }

        } catch (Exception e) {
            System.err.println("Error processing the RSS feed: " + e.getMessage());
        }
    }
}
