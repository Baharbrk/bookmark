package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {

    public String url;

    // Getter
    public String getUrl() {
        return url;
    }

    // Setter
    public void setUrl(String url) {
        this.url = url;
    }

    public boolean validateUrl()
    {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.url);

        return matcher.matches();
    }
}
