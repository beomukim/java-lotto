package lotto;

import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoMachine(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }


}
