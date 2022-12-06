package lotto;

import java.util.Arrays;
import java.util.Collection;

public class Validator {

    private String[] winningNumber;
    public void validateMoney(String money) {
        toInteger(money);
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumber(String numbers) {
        this.winningNumber = numbers.split(",");
        Arrays.stream(winningNumber).forEach(this::validateLottoNumber);
        if (Arrays.stream(winningNumber).distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        validateLottoNumber(bonusNumber);
        if (Arrays.stream(winningNumber).anyMatch(n -> n.equals(bonusNumber))) {
            throw new IllegalArgumentException();
        }
    }
    private Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumber(String number) {
        toInteger(number);
        int lottoNumber = Integer.parseInt(number);
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
