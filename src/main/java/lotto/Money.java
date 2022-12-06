package lotto;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return money / 1000;
    }
}
