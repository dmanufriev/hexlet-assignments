package exercise;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(man -> LocalDate.parse(man.get("birthday"))))
                .map(man -> man.get("name"))
                .toList();
    }
}

// END
