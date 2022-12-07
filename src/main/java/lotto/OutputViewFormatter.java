package lotto;

import java.text.DecimalFormat;

public class OutputViewFormatter {
    private static final String MATCH_COUNT_FORMAT = "%s개 일치";
    private static final DecimalFormat MONEY_DECIMAL_FORMAT = new DecimalFormat("#,###");
    private static final String MATCH_BONUS_NUMBER_GUIDE = ", 보너스 볼 일치";
    private static final String REWARD_FORMAT = " (%s원)";
    private static final String COUNT_FORMAT = " - %s개";
    private static final String PERCENT = "%";
    private static final String YIELD_FORMAT = "%,.1f";
    private static final String YIELD_TEXT_FORMAT = "총 수익률은 %s%s입니다.";
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public String outputRankFormat(WinningLotto winningLotto, int count) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(MATCH_COUNT_FORMAT, winningLotto.getWinningNuberCount()));
        if (winningLotto == WinningLotto.SECOND) {
            result.append(MATCH_BONUS_NUMBER_GUIDE);
        }
        result.append(String.format(REWARD_FORMAT, outputMoneyFormat(winningLotto)));
        result.append(String.format(COUNT_FORMAT, count));
        return result.toString();
    }

    private String outputMoneyFormat(WinningLotto winningLotto) {
        return MONEY_DECIMAL_FORMAT.format(winningLotto.getWinningPrice());
    }
}
