package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    OutputViewFormatter outputViewFormatter = new OutputViewFormatter();
    public void printResult(Map<WinningLotto, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        /*
         * 3개 일치 (5,000원) - 1개
         * 4개 일치 (50,000원) - 0개
         * 5개 일치 (1,500,000원) - 0개
         * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
         * 6개 일치 (2,000,000,000원) - 0개
         * 총 수익률은 62.5%입니다.
         */

        for (WinningLotto winningLotto : getSortedWinningLottos(result)) {
            String s = outputViewFormatter.outputRankFormat(winningLotto, result.get(winningLotto));
            System.out.println(s);
        }
    }

    private static List<WinningLotto> getSortedWinningLottos(Map<WinningLotto, Integer> result) {
        List<WinningLotto> winningLottos = result.keySet().stream()
                .sorted(Comparator.comparing(WinningLotto::getWinningPrice)).collect(
                        Collectors.toList());
        return winningLottos;
    }

    public void printStatistics(Map<WinningLotto, Integer> result, int money) {

    }
}
