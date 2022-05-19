package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Bookmark {

    public HashMap<String, List<String>> savedUrls = new HashMap<String, List<String>>();

    public boolean saveUrl(String url)
    {
        List<String> urls = new ArrayList<>();
        if (validateUrl(url)) {
            urls.add(url);
            savedUrls.put("urls", urls);
            return true;
        }

        return false;
    }

    public boolean validateUrl(String url) {
        String urlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
