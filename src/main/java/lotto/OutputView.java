package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    OutputViewFormatter outputViewFormatter = new OutputViewFormatter();
    public void printResult(Map<WinningLotto, Integer> result, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        getSortedWinningLottos(result).forEach(winningLotto -> System.out.println(
                outputViewFormatter.outputRankFormat(winningLotto, result.get(winningLotto))));
        printProfit(result, money);

    }

    private void printProfit(Map<WinningLotto, Integer> result, Money money) {
        int sum = result.keySet().stream()
                .filter(winningLotto -> result.get(winningLotto) > 0).mapToInt(WinningLotto::getWinningPrice).sum();
        int price = money.getMoney();
        System.out.println(outputViewFormatter.outputYieldFormat((double) sum / price * 100));
    }

    private static List<WinningLotto> getSortedWinningLottos(Map<WinningLotto, Integer> result) {
        List<WinningLotto> winningLottos = result.keySet().stream()
                .sorted(Comparator.comparing(WinningLotto::getWinningPrice)).collect(
                        Collectors.toList());
        return winningLottos;
    }
}
