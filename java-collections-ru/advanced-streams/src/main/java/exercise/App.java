package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String configString) {
        final String LINE_START_PATTERN = "environment=\"";
        final String VAR_START_PATTERN = "X_FORWARDED_";

        String[] lines = configString.split("\n");
        return Stream.of(lines)
                    .filter(l -> l.startsWith(LINE_START_PATTERN))
                    .map(l -> l.substring(LINE_START_PATTERN.length(), l.length() - 1))
                    .flatMap(l -> Stream.of(l.split(",")))
                    .filter(l -> l.startsWith(VAR_START_PATTERN))
                    .map(l -> l.replace(VAR_START_PATTERN, ""))
                    .collect(Collectors.joining(","));
    }
}

//END
