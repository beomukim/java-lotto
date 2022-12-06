package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    private int count;

    public LottoMaker(Money money) {
        this.count = money.getCount();
    }

    public List<Lotto> makeLotto() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
