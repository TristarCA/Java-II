package rssfeedexample;

import java.io.PrintStream;

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

    public boolean equals(RSSItem rssItem) {
        return this.title.equals(rssItem.title) && this.link.equals(rssItem.link) && this.pubDate.equals(rssItem.pubDate);
    }
}

