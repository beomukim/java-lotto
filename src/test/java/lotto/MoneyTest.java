package lotto;

import static lotto.ErrorMessage.MONEY_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다")
    @Test
    void moneyTest() {
        assertThatThrownBy(() -> new Money(850))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_ERROR_MESSAGE);
    }
}
