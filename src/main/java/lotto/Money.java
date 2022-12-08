package lotto;

import static lotto.Rules.LOTTO_PRICE;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private static void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / 1000;
    }
}
