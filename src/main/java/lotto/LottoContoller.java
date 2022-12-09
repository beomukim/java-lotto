package lotto;

import java.util.List;
import java.util.Map;

public class LottoContoller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void lottoPlay() {
        Money price = getPrice();
        List<Lotto> lottos = makeLottos(price);
        printResultAndProfit(price, lottos);
    }

    private void printResultAndProfit(Money price, List<Lotto> lottos) {
        LottoMachine lottoMachine = getLottoMachine(lottos);
        Map<WinningLotto, Integer> result = lottoMachine.getResult();
        double profit = lottoMachine.calculateProfit(result, price);
        outputView.printResult(result);
        outputView.printProfit(profit);
    }

    private LottoMachine getLottoMachine(List<Lotto> lottos) {
        outputView.suggestWinningNumber();
        List<Integer> winningNumber = inputView.readWinningNumber();

        outputView.suggestBonusNumber();
        Integer bonusNumber = inputView.readBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(lottos, winningNumber, bonusNumber);
        return lottoMachine;
    }

    private List<Lotto> makeLottos(Money price) {
        LottoMaker lottoMaker = new LottoMaker(price);
        List<Lotto> lottos = lottoMaker.makeLotto();
        outputView.printLottos(lottos);
        return lottos;
    }

    private Money getPrice() {
        outputView.suggestPrice();
        Money price = inputView.readPrice();
        outputView.printLottoCount(price);
        return price;
    }
}
