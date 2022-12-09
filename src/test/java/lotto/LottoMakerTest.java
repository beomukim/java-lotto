package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lotto.Rules.WINNING_NUMBER_END_NUMBER;
import static lotto.Rules.WINNING_NUMBER_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {

    private Money money;
    private LottoMaker lottoMaker;

    @BeforeEach
    void setMoney() {
        money = new Money(8000);
        lottoMaker = new LottoMaker(money);
    }

    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = lottoMaker.makeLotto();
        assertThat(lottos.size()).isEqualTo(money.getCount());
        assertThat(lottos.stream()
                .map(Lotto::getNumbers)
                .flatMap(Collection::stream)
                .allMatch(n -> n >= WINNING_NUMBER_START_NUMBER && n <= WINNING_NUMBER_END_NUMBER))
                .isTrue();
    }
}
