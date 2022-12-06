package lotto;

import java.util.Arrays;

public enum WinningLotto {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private int winningNuberCount;
    private int winningPrice;

    WinningLotto(int winningNuberCount, int winningPrice) {
        this.winningNuberCount = winningNuberCount;
        this.winningPrice = winningPrice;
    }



    public static boolean isNothing(WinningLotto winningLotto) {
        return winningLotto == WinningLotto.NOTHING;
    }
}
