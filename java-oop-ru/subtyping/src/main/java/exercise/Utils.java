// Методы класса в этом файл нужны для самостоятельной работы

package exercise;

import java.nio.file.*;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

class Utils {
    public static String serialize(Map<String, String> map) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

    public static Map<String, String> unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = new HashMap<>();
        try {
            data = mapper.readValue(json, Map.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static String readFile(String path) {
        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        String content = "";
        try {
            content = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return content;
    }

    public static void writeFile(String path, String content) {
        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        try {
            OpenOption[] oo4 = new OpenOption[] {StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE};
            Files.writeString(fullPath, content, oo4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
