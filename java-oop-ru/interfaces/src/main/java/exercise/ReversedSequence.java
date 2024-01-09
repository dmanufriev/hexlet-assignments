package exercise;

import org.apache.commons.lang3.StringUtils;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String reversedString;

    public ReversedSequence(String initString) {
        reversedString = StringUtils.reverse(initString);
    }

    @Override
    public int length() {
        return reversedString.length();
    }

    @Override
    public char charAt(int i) {
        return reversedString.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return reversedString.subSequence(i, i1);
    }
}
// END
