package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String text) {

        Map<String, Integer> wordsCount = new HashMap<>();

        if (text.isEmpty()) {
            return wordsCount;
        }

        String[] words = text.split(" ");
        for (var word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {

        if ((wordsCount == null) || wordsCount.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder("{\n");

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            builder.append("  ");
            builder.append(entry.getKey());
            builder.append(": ");
            builder.append(entry.getValue());
            builder.append("\n");
        }
        builder.append("}");

        return builder.toString();
    }
}

//END
