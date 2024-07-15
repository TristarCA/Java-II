package rssfeedexample;

import java.io.PrintStream;
import java.util.Objects;

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
