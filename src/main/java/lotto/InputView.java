package lotto;

import static lotto.Rules.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private Validator validator = new Validator();

    //TODO : 예외처리
    public Money readPrice() {
        String money = Console.readLine();
        validator.toInteger(money);
        Money price = new Money(Integer.parseInt(money));
        return price;
    }

    public List<Integer> readWinningNumber() {
        String numbers = Console.readLine();
        validator.validateWinningNumber(numbers);
        return Arrays.stream(numbers.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer readBonusNumber() {
        String bonusNumber = Console.readLine();
        validator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}

