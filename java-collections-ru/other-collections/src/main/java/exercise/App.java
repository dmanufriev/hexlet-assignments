package exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, String> resultMap = new LinkedHashMap<>();

        Set<String> keysSet = new LinkedHashSet<>();
        keysSet.addAll(map1.keySet());
        keysSet.addAll(map2.keySet());

        for (String key : keysSet) {
            boolean isKeyFromMap1 = map1.containsKey(key);
            boolean isKeyFromMap2 = map2.containsKey(key);
            if (isKeyFromMap1 && isKeyFromMap2) {
                resultMap.put(key, map1.get(key).equals(map2.get(key)) ? "unchanged" : "changed");
            } else if (isKeyFromMap1) {
                resultMap.put(key, "deleted");
            } else {
                resultMap.put(key, "added");
            }
        }

        return resultMap;
    }
}

//END
