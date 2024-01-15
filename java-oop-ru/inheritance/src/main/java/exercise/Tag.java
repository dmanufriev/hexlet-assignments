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

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<").append(getName());
        builder.append(getAttributes().entrySet().stream()
                .map((entry) -> new StringBuilder(" ")
                                        .append(entry.getKey().toString())
                                        .append("=\"" )
                                        .append(entry.getValue())
                                        .append("\"")
                                        .toString())
                .collect(Collectors.joining(""))
        );
        builder.append(">");
        return builder.toString();
    }
}

// END
