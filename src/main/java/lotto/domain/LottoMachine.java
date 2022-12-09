package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LottoMachine {
    private List<Lotto> lottos;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoMachine(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningLotto, Integer> getResult() {
        Map<WinningLotto, Integer> result = getWinningLottoIntegerMap();
        lottos.stream()
                .map(this::checkLotto)
                .filter(winningLotto -> winningLotto.getWinningPrice() > 0)
                .forEach(winningLotto -> result.put(winningLotto, result.get(winningLotto) + 1));

        return result;
    }

    private static Map<WinningLotto, Integer> getWinningLottoIntegerMap() {
        Map<WinningLotto, Integer> result = new HashMap<>();
        Arrays.stream(WinningLotto.values())
                .filter(winningLotto -> winningLotto.getWinningPrice() > 0)
                .forEach(winningLotto -> result.put(winningLotto, 0));


        return result;
    }

    private WinningLotto checkLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = (int) numbers.stream()
                .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                .count();
        boolean hasBonus = numbers.contains(bonusNumber);

        WinningLotto winningLotto = WinningLotto.from(count, hasBonus);
        return winningLotto;
    }

    public double calculateProfit(Map<WinningLotto, Integer> result, Money money) {
        int sum = result.keySet().stream()
                .filter(winningLotto -> result.get(winningLotto) > 0).mapToInt(WinningLotto::getWinningPrice).sum();
        int price = money.getMoney();
        return (double) sum / price * 100;
    }
}
