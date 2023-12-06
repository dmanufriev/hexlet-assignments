package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> valuesList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        Assertions.assertArrayEquals(expectedList.toArray(), App.take(valuesList, 2).toArray());
        Assertions.assertArrayEquals(valuesList.toArray(), App.take(valuesList, 10).toArray());
        Assertions.assertEquals(0, App.take(valuesList, 0).size());
        Assertions.assertEquals(0, App.take(new ArrayList<>(), 0).size());
        Assertions.assertEquals(0, App.take(new ArrayList<>(), 3).size());
        // END
    }
}
