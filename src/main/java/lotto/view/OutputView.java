package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class OutputView {
    public static final String STASTISTICS = "당첨 통계";
    public static final String SPLIT = "---";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    OutputViewFormatter outputViewFormatter = new OutputViewFormatter();
    public void printResult(Map<WinningLotto, Integer> result) {
        System.out.println(STASTISTICS);
        System.out.println(SPLIT);

        getSortedWinningLottos(result).forEach(winningLotto -> System.out.println(
                outputViewFormatter.outputRankFormat(winningLotto, result.get(winningLotto))));
    }

    public void printProfit(Double profit) {
        System.out.println(outputViewFormatter.outputYieldFormat(profit));
    }

    private static List<WinningLotto> getSortedWinningLottos(Map<WinningLotto, Integer> result) {
        List<WinningLotto> winningLottos = result.keySet().stream()
                .sorted(Comparator.comparing(WinningLotto::getWinningPrice)).collect(
                        Collectors.toList());
        return winningLottos;
    }

    public void suggestBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void suggestWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public void printLottoCount(Money price) {
        System.out.println(price.getCount() + LOTTO_COUNT_MESSAGE);
    }

    public void suggestPrice() {
        System.out.println(PRICE_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
