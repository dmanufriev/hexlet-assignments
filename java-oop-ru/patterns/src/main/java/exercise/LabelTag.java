package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String type;
    private TagInterface tagInterface;

    public LabelTag(String type, TagInterface tagInterface) {
        this.type = type;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return new StringBuilder("<label>").append(type)
                                            .append(tagInterface.render())
                                            .append("</label>")
                                            .toString();
    }
}

// END
