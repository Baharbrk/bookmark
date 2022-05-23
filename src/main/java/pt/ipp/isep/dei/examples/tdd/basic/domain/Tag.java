package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;

public class Tag {

    public String name;
    public List<String> tags = new ArrayList<>();

    public Tag(String tagName) {
        this.name = tagName;
        this.tags.add(tagName);
    }

    public List<String> getTags() {
        return this.tags;
    }
}
