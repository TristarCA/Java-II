package rssfeedexample;

import java.io.PrintStream;
import java.util.Objects;

/**
 * represents an item in an RSS feed. It includes the title, link and publication date of the item
 * It also provides methods for accessing these feilds and printing them
 */
public class RSSItem {
    private final String title;
    private final String link;
    private final String pubDate;

    public RSSItem(String title, String link, String pubDate) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void print(PrintStream out) {
        out.println(title);
        out.println(link);
        out.println(pubDate);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o: The reference object with which to compare.
     * @return true if this object is the same as the obj argument; otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RSSItem rssItem = (RSSItem) o;
        return Objects.equals(title, rssItem.title) &&
                Objects.equals(link, rssItem.link) &&
                Objects.equals(pubDate, rssItem.pubDate);
    }
}
