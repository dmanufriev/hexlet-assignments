package exercise;

import org.apache.commons.lang3.StringUtils;
import java.util.List;

// BEGIN
public class App {

    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeHosts = List.of("gmail.com", "yandex.ru", "hotmail.com");

        if (emails == null) {
            return 0;
        }

        return emails.stream()
                .filter(email -> StringUtils.isNoneBlank(email))
                .filter(email -> email.contains("@"))
                .map(email -> email.substring(email.indexOf('@') + 1))
                .filter(host -> freeHosts.contains(host))
                .count();
    }
}
// END
