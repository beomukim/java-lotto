package lotto;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumber, Integer bonusNumber) {
        validate(winningNumber);
        validate(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }
        winningNumber.forEach(this::validate);
    }

    private void validate(Integer lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
    }


}
