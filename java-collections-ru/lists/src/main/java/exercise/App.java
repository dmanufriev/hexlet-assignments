package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static boolean scrabble(String lettersStr, String target) {

        char[] targetLetters = target.toLowerCase().toCharArray();
        List<Character> lettersList = lettersStr.toLowerCase().chars().
                        mapToObj(e -> (char) e).collect(Collectors.toList());

        for (var letter : targetLetters) {
            int idx = lettersList.indexOf(letter);
            if (idx < 0) {
                return false;
            }
            lettersList.remove(idx);
        }
        return true;
    }
}
//END
