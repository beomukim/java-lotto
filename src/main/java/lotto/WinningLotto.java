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

    public int getWinningNuberCount() {
        return winningNuberCount;
    }

    public static WinningLotto from(int winningNuberCount, boolean hasBonus) {
        if (winningNuberCount == SECOND.winningNuberCount && hasBonus) {
            return WinningLotto.SECOND;
        }
        if (winningNuberCount == THIRD.winningNuberCount && !hasBonus) {
            return WinningLotto.THIRD;
        }
        return Arrays.stream(WinningLotto.values()).filter(item -> item.getWinningNuberCount() == winningNuberCount)
                .findFirst().orElse(WinningLotto.NOTHING);
    }

    public static boolean isNothing(WinningLotto winningLotto) {
        return winningLotto == WinningLotto.NOTHING;
    }
}
