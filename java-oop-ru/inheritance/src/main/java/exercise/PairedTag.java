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
        StringBuilder builder = new StringBuilder(super.toString());
        for (Tag tag : tags) {
            builder.append(tag.toString());
        }
        builder.append(body);
        builder.append("</").append(getName()).append(">");
        return builder.toString();
    }
}

// END
