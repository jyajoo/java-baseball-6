package baseball;

import static baseball.status.ErrorCode.INVALID_DISTINCT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT;
import static baseball.status.ErrorCode.INVALID_LENGTH_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("올바른 입력_서로 다른 3자리 수")
    void setInputTest() {
        Game game = new Game();
        List<Integer> inputNum = game.getIntegerInput("123");
        assertThat(inputNum).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("잘못된 입력_3자리 수보다 적은 경우")
    void validationInputTest2() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("12"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("1"));
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput(""));

        assertThat(INVALID_LENGTH_INPUT.getMsg()).isEqualTo(exception.getMessage());
        assertThat(INVALID_LENGTH_INPUT.getMsg()).isEqualTo(exception2.getMessage());
        assertThat(INVALID_LENGTH_INPUT.getMsg()).isEqualTo(exception3.getMessage());
    }

    @Test
    @DisplayName("잘못된 입력_3자리 수보다 많은 경우")
    void validationInputTest3() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("1234"));

        assertThat(INVALID_LENGTH_INPUT.getMsg()).isEqualTo(exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 입력_숫자 대신 문자인 경우")
    void validationInputTest4() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("12a"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("1.5"));
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("pen"));

        assertThat(INVALID_FORMAT_INPUT.getMsg()).isEqualTo(exception.getMessage());
        assertThat(INVALID_FORMAT_INPUT.getMsg()).isEqualTo(exception2.getMessage());
        assertThat(INVALID_FORMAT_INPUT.getMsg()).isEqualTo(exception3.getMessage());
    }

    @Test
    @DisplayName("잘못된 입력_1 ~ 9에 해당하지 않는 경우")
    void validationInputTest5() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("120"));

        assertThat(INVALID_FORMAT_INPUT.getMsg()).isEqualTo(exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 입력_중복된 숫자가 존재하는 경우")
    void validationInputTest6() {
        Game game = new Game();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("151"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> game.getIntegerInput("133"));

        assertThat(INVALID_DISTINCT_INPUT.getMsg()).isEqualTo(exception.getMessage());
        assertThat(INVALID_DISTINCT_INPUT.getMsg()).isEqualTo(exception2.getMessage());
    }

}