package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class ReversedSequenceTest {
    String str;
    ReversedSequence reversedSequence;

    @BeforeEach
    void beforeEach() {
        str = "Hello";
        reversedSequence = new ReversedSequence(str);
    }

    @Test
    void positiveTest() {
        assertThat(reversedSequence.length()).isEqualTo(str.length());
        assertThat(reversedSequence.charAt(0)).isEqualTo('o');
        assertThat(reversedSequence.subSequence(1, 3)).isEqualTo("ll");
        assertThat(reversedSequence.subSequence(0, str.length())).isEqualTo("olleH");
    }

    @Test
    void charAtOutOfBoundsTest() {
        var thrown = catchThrowable(() -> {
            reversedSequence.charAt(-1);
        });
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    void subsequenceOutOfBoundsTest() {
        var thrown = catchThrowable(() -> {
            reversedSequence.subSequence(0, 10);
        });
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}