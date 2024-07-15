package rssfeedexample;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSSFeedChecker implements Runnable {
    private String feedUrl;
    private int sleep;
    private List<RSSItem> knownItems = new ArrayList<>();

    public RSSFeedChecker(String feedUrl, int sleep) {
        this.feedUrl = feedUrl;
        this.sleep = sleep;
    }

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
                    RSSItem newArticle = new RSSItem(
                            itemElement.getElementsByTagName("title").item(0).getTextContent(),
                            itemElement.getElementsByTagName("link").item(0).getTextContent(),
                            itemElement.getElementsByTagName("pubDate").item(0).getTextContent()
                    );

                    if (!knownItems.contains(newArticle)) {
                        newArticleFound = true;
                        knownItems.add(newArticle);
                        newArticle.print(System.out);
                    }
                    items.add(newArticle);
                }
            }

            if (!newArticleFound) {
                System.out.println("No new articles have been posted to the RSS feed at " + feedUrl);
            }

            knownItems = new ArrayList<>(items);
        } catch (Exception e) {
            System.err.println("Error processing the RSS feed: " + e.getMessage());
        }
    }
}
