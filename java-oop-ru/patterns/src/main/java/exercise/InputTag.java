package exercise;

// BEGIN
public class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String render() {
        return new StringBuilder("<input type=\"").append(type)
                                .append("\" value=\"").append(value).append("\">")
                                .toString();
    }
}

// END
