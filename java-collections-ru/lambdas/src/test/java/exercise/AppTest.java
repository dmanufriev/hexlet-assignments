package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void enlargeArrayImageTestWithEmptyArray() {
        String[][] actual = new String[0][0];
        String[][] expected = new String[0][0];
        assertThat(App.enlargeArrayImage(actual)).isEqualTo(expected);
    }

    @Test
    void enlargeArrayImageTestHorizontal() {
        String[][] actual = new String[][]{{"1", "2", "3"}};
        String[][] expected = new String[][]{{"1", "1", "2", "2", "3", "3"},
                                             {"1", "1", "2", "2", "3", "3"}};
        assertThat(App.enlargeArrayImage(actual)).isEqualTo(expected);
    }

    @Test
    void enlargeArrayImageTestVertical() {
        String[][] actual = new String[][]{{"1"}, {"2"}, {"3"} };
        String[][] expected = new String[][]{{"1", "1"}, {"1", "1"},
                                             {"2", "2"}, {"2", "2"},
                                             {"3", "3"}, {"3", "3"}};
        assertThat(App.enlargeArrayImage(actual)).isEqualTo(expected);
    }
}

// END
