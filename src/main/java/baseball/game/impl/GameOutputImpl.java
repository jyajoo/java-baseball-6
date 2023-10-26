package baseball.game.impl;

import static baseball.status.GameMsg.BALL;
import static baseball.status.GameMsg.BALL_AND_STRIKE;
import static baseball.status.GameMsg.NOTHING;
import static baseball.status.GameMsg.STRIKE;

import baseball.game.GameOutput;

public class GameOutputImpl implements GameOutput {

    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 볼, 스트라이크, 낫싱 출력 메시지 생성
     *
     * @param result [볼, 스트라이크]
     */
    public String output(int[] result) {
        int ball = result[0];
        int strike = result[1];

        StringBuilder stringBuilder = new StringBuilder();

        if (strike > 0 && ball == 0) {
            stringBuilder.append(STRIKE.getMsg().formatted(strike));
        }

        if (strike == 0 && ball > 0) {
            stringBuilder.append(BALL.getMsg().formatted(ball));
        }

        if (strike > 0 && ball > 0) {
            stringBuilder.append(BALL_AND_STRIKE.getMsg().formatted(ball, strike));
        }

        if (strike == 0 && ball == 0) {
            stringBuilder.append(NOTHING.getMsg());
        }
        return stringBuilder.toString();
    }
}
