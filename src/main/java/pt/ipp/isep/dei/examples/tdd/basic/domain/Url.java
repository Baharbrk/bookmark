package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {

    public String url;
    public ArrayList<Tag> tags = new ArrayList<Tag>();

    public Url(String url) {
        this.url = url;
    }

    public boolean validateUrl()
    {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.url);

        return matcher.matches();
    }

    public boolean isUrlSecure() {
        String search = "HTTPS";

        return this.url.toLowerCase().contains(search.toLowerCase());
    }

    public void tagUrl(Tag tag) {
        this.tags.add(tag);
    }
}
