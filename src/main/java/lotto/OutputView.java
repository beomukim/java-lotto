package lotto;

import java.util.Map;

public class OutputView {
    public void printResult(Map<WinningLotto, Integer> result) {
        System.out.println("당첨 통계\n");
        System.out.println("---");
        /*
         * 3개 일치 (5,000원) - 1개
         * 4개 일치 (50,000원) - 0개
         * 5개 일치 (1,500,000원) - 0개
         * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
         * 6개 일치 (2,000,000,000원) - 0개
         * 총 수익률은 62.5%입니다.
         */

    }
}
