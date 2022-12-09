package lotto.domain;

import static lotto.util.Rules.LOTTO_COUNT;
import static lotto.util.Rules.WINNING_NUMBER_END_NUMBER;
import static lotto.util.Rules.WINNING_NUMBER_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Rules;

public class LottoMaker {
    private int count;

    public LottoMaker(Money money) {
        this.count = money.getCount();
    }

    public List<Lotto> makeLotto() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(WINNING_NUMBER_START_NUMBER,
                    WINNING_NUMBER_END_NUMBER, LOTTO_COUNT);
            lottos.add(new Lotto(numbers.stream().sorted().collect(Collectors.toList())));
        }

        return lottos;
    }
}
