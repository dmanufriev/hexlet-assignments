package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static String[] duplicateElements(String[] array) {
        return Arrays.stream(array)
                .flatMap(e -> Arrays.stream(new String[]{e, e}))
                .toArray(String[]::new);
    }

    public static String[][] enlargeArrayImage(String[][] array) {

        if ((array.length == 0) || (array[0].length == 0)) {
            return new String[0][0];
        }

        String[][] doubledHorizontallyArray = Arrays.stream(array)
                                                .map(App::duplicateElements)
                                                .toArray(String[][]::new);

        return Arrays.stream(doubledHorizontallyArray)
                .flatMap(e -> Arrays.stream(new String[][] {e, e}))
                .toArray(String[][]::new);
    }
}

// END
