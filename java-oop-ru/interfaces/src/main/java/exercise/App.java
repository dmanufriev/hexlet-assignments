package exercise;

import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {

        return homes.stream()
                      .sorted()
                      .map((home) -> home.toString())
                      .limit(n)
                      .toList();
    }
}
// END
