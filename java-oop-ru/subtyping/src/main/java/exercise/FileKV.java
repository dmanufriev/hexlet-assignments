package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> storage) {
        this.filePath = new String(filePath);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(filePath));
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(filePath));
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storage = Utils.unserialize(Utils.readFile(filePath));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(filePath));
    }
}

// END
