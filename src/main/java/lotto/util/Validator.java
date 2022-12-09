package lotto.util;

import static lotto.util.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.util.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.util.ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE;
import static lotto.util.Rules.COMMA;
import static lotto.util.Rules.LOTTO_COUNT;
import static lotto.util.Rules.WINNING_NUMBER_END_NUMBER;
import static lotto.util.Rules.WINNING_NUMBER_START_NUMBER;

import java.util.Arrays;

public class Validator {

    private String[] winningNumber;

    public void validateWinningNumber(String numbers) {
        this.winningNumber = numbers.split(COMMA);
        Arrays.stream(winningNumber).forEach(this::validateLottoNumber);
        if (Arrays.stream(winningNumber).distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(String bonusNumber) {
        validateLottoNumber(bonusNumber);
        if (Arrays.asList(winningNumber).contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
    public Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateLottoNumber(String number) {
        toInteger(number);
        int lottoNumber = Integer.parseInt(number);
        if (lottoNumber < WINNING_NUMBER_START_NUMBER || lottoNumber > WINNING_NUMBER_END_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }
}
