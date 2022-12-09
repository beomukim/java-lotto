package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setLottoMachine() {
        Lotto lottos1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottos2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lottos3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoMachine = new LottoMachine(List.of(lottos1, lottos2, lottos3), winningNumbers, bonusNumber);
    }

    @ParameterizedTest
    @EnumSource(mode = Mode.INCLUDE, names = {"FIRST", "SECOND", "THIRD"})
    void 당첨_로또_판별_테스트(WinningLotto winningLotto) {
        Map<WinningLotto, Integer> result = lottoMachine.getResult();
        assertThat(result.keySet()).doesNotContain(WinningLotto.NOTHING);
        assertThat(result.get(winningLotto)).isGreaterThan(0);
    }

    @Test
    void 수익률_계산_테스트() {
        Map<WinningLotto, Integer> result = lottoMachine.getResult();
        int sum = result.keySet().stream().filter(winningLotto -> result.get(winningLotto) > 0)
                .mapToInt(WinningLotto::getWinningPrice).sum();
        Money money = new Money(8000);
        assertThat(lottoMachine.calculateProfit(result, money)).isEqualTo((double) sum / money.getMoney() * 100);
    }


}
