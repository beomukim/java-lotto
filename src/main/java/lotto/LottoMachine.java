package lotto;

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
        Map<WinningLotto, Integer> result = new HashMap<>();

        return result;
    }

    private WinningLotto checkLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        long count = numbers.stream()
                .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                .count();


    }


}
