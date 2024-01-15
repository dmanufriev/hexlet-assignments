package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public String getAttributesString() {
        return attributes.entrySet().stream()
                                    .map((entry) -> String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()))
                                    .collect(Collectors.joining(""));
    }
}

// END
