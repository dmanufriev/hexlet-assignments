package exercise;

// BEGIN
public class App {

    public static String[][] enlargeArrayImage(String[][] array) {

        if ((array.length == 0) || (array[0].length == 0)) {
            return new String[0][0];
        }

        String[][] resultArray = new String[array.length * 2][array[0].length * 2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                resultArray[2 * i][2 * j] = array[i][j];
                resultArray[2 * i][2 * j + 1] = array[i][j];
                resultArray[2 * i + 1][2 * j] = array[i][j];
                resultArray[2 * i + 1][2 * j + 1] = array[i][j];
            }
        }

        return resultArray;
    }
}

// END
