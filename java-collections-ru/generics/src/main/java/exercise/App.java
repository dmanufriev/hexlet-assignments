package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {

    public static <T> List<Map<T, T>> findWhere(List<Map<T, T>> books, Map<T, T> where) {

        List<Map<T, T>> foundBooks = new ArrayList<>();

        for (var book : books) {
            boolean isEqual = true;
            for (Entry<T, T> entry : where.entrySet()) {
                T bookValue = book.get(entry.getKey());
                if ((bookValue == null) || !bookValue.equals(entry.getValue())) {
                    isEqual = false;
                }
            }
            if (isEqual) {
                foundBooks.add(book);
            }
        }

        return foundBooks;
    }
}

//END
