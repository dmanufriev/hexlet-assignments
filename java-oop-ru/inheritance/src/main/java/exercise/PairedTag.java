package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> tags;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> tags) {
        super(name, attributes);
        this.body = body;
        this.tags = tags;
    }

    @Override
    public String toString() {
        String name = getName();
        String attributesString = getAttributesString();
        String tagsString = tags.stream()
                                .map(Tag::toString)
                                .collect(Collectors.joining(""));

        return String.format("<%s%s>%s%s</%s>", name, attributesString, tagsString, body, name);
    }
}

// END
