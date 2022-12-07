package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            System.out.println("구입금액을 입력해 주세요.");
            int money = inputView.readPrice();

            Money price = new Money(money);
            System.out.println(price.getCount() + "개를 구매했습니다.");
            LottoMaker lottoMaker = new LottoMaker(price);
            List<Lotto> lottos = lottoMaker.makeLotto();
            lottos.forEach(System.out::println);

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumber = inputView.readWinningNumber();

            System.out.println("보너스 번호를 입력해 주세요.");
            Integer bonusNumber = inputView.readBonusNumber();

            LottoMachine lottoMachine = new LottoMachine(lottos, winningNumber, bonusNumber);
            Map<WinningLotto, Integer> result = lottoMachine.getResult();
            outputView.printResult(result);
            outputView.printStatistics(result, money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] ");
        }
    }
}
