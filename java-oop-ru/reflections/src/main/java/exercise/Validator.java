package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {

        List<String> invalidFields = new ArrayList<>();

        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (null == field.get(address)) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        Map<String, List<String>>   invalidFields = new HashMap<>();

        for (Field field : address.getClass().getDeclaredFields()) {

            String fieldValue;
            try {
                field.setAccessible(true);
                fieldValue = (String)field.get(address);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }

            if (field.isAnnotationPresent(NotNull.class) && (null == fieldValue)) {
                addFaultDescription(invalidFields, field.getName(), "can not be null");
                continue;
            }

            MinLength fieldLength = field.getAnnotation(MinLength.class);
            if ((null != fieldLength) && (fieldValue.length() < fieldLength.minLength())) {
                addFaultDescription(invalidFields, field.getName(),
                                "length less than " + fieldLength.minLength());
            }
        }
        return invalidFields;
    }

    private static void addFaultDescription(Map<String, List<String>> map, String key, String value) {
        List<String> values = map.getOrDefault(key, new ArrayList<>());
        values.add(value);
        map.put(key, values);
    }
}

// END
