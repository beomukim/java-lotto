package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return lottos.stream().map(this::checkLotto)
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
    }

    private WinningLotto checkLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = (int) numbers.stream()
                .filter(n -> winningNumber.stream().anyMatch(Predicate.isEqual(n)))
                .count();
        boolean hasBonus = winningNumber.contains(bonusNumber);

        WinningLotto winningLotto = WinningLotto.from(count, hasBonus);
        return winningLotto;
    }


}
