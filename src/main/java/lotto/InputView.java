package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private Validator validator = new Validator();

    //TODO : 예외처리
    public int readPrice() {
        String money = Console.readLine();
        validator.validateMoney(money);
        return Integer.parseInt(money);
    }

    public List<Integer> readWinningNumber() {
        String numbers = Console.readLine();
        validator.validateWinningNumber(numbers);
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer readBonusNumber() {
        String bonusNumber = Console.readLine();
        validator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}

