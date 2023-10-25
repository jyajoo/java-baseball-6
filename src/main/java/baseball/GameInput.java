package baseball;

import static baseball.status.ErrorCode.INVALID_DISTINCT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT;
import static baseball.status.ErrorCode.INVALID_LENGTH_INPUT;
import static baseball.status.GameSetting.COUNT_NUM;
import static baseball.status.GameSetting.INPUT_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInput {

    /**
     * 입력받기
     *
     * @return 입력 값
     */
    public String setInput() {
        return Console.readLine();
    }

    /**
     * 입력 받은 문자열을 Integer 리스트로 변환
     *
     * @param input 입력 값
     * @return 숫자로 변환된 입력 수
     */
    public List<Integer> getIntegerInput(String input) {
        String[] inputArr = input.split("");
        validationInput(inputArr);

        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < COUNT_NUM.getValue(); i++) {
            inputNum.add(Integer.parseInt(inputArr[i]));
        }
        return inputNum;
    }

    /**
     * 입력 값 유효성 체크
     *
     * @param input 입력 값
     */
    private void validationInput(String[] input) {
        if (input.length != COUNT_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT.getMsg());
        }

        for (String s : input) {
            if (!s.matches(INPUT_REGEX.getStringValue())) {
                throw new IllegalArgumentException(INVALID_FORMAT_INPUT.getMsg());
            }
        }

        if (Arrays.stream(input).distinct().count() != COUNT_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_DISTINCT_INPUT.getMsg());
        }
    }
}
