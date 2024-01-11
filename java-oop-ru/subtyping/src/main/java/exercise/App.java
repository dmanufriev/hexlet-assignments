package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue (KeyValueStorage keyValueStorage) {
        for (var entryStorage : keyValueStorage.toMap().entrySet()) {
            keyValueStorage.unset(entryStorage.getKey());
            keyValueStorage.set(entryStorage.getValue(), entryStorage.getKey());
        }
    }
}

// END
