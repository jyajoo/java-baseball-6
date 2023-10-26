package baseball;

import static baseball.status.GameMsg.BALL;
import static baseball.status.GameMsg.BALL_AND_STRIKE;
import static baseball.status.GameMsg.NOTHING;
import static baseball.status.GameMsg.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.GameOutput;
import baseball.game.impl.GameOutputImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameOutputImplTest {
    @Test
    @DisplayName("출력 메시지 테스트_볼")
    void outputTest() {
        GameOutput gameOutput = new GameOutputImpl();

        String output = gameOutput.output(new int[]{1, 0});
        String output2 = gameOutput.output(new int[]{2, 0});
        String output3 = gameOutput.output(new int[]{3, 0});
        assertThat(output).isEqualTo(BALL.getMsg().formatted(1));
        assertThat(output2).isEqualTo(BALL.getMsg().formatted(2));
        assertThat(output3).isEqualTo(BALL.getMsg().formatted(3));
    }

    @Test
    @DisplayName("출력 메시지 테스트_스트라이크")
    void outputTest2() {
        GameOutput gameOutput = new GameOutputImpl();

        String output = gameOutput.output(new int[]{0, 1});
        String output2 = gameOutput.output(new int[]{0, 2});
        String output3 = gameOutput.output(new int[]{0, 3});
        assertThat(output).isEqualTo(STRIKE.getMsg().formatted(1));
        assertThat(output2).isEqualTo(STRIKE.getMsg().formatted(2));
        assertThat(output3).isEqualTo(STRIKE.getMsg().formatted(3));
    }

    @Test
    @DisplayName("출력 메시지 테스트_볼, 스트라이크")
    void outputTest3() {
        GameOutput gameOutput = new GameOutputImpl();

        String output = gameOutput.output(new int[]{1, 1});
        String output2 = gameOutput.output(new int[]{2, 1});
        assertThat(output).isEqualTo(BALL_AND_STRIKE.getMsg().formatted(1, 1));
        assertThat(output2).isEqualTo(BALL_AND_STRIKE.getMsg().formatted(2, 1));
    }

    @Test
    @DisplayName("출력 메시지 테스트_낫싱")
    void outputTest4() {
        GameOutput gameOutput = new GameOutputImpl();

        String output = gameOutput.output(new int[]{0, 0});
        assertThat(output).isEqualTo(NOTHING.getMsg());
    }
}