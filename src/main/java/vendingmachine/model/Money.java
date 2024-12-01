package vendingmachine.model;

import static vendingmachine.util.ErrorMessage.ERROR_MONEY_ONLY_NUMBER;
import static vendingmachine.util.ErrorMessage.ERROR_NEGATIVE;

public class Money {

    private int money;

    public Money(String inputMoney) {
        this.money = parseToInteger(inputMoney);
        validateNegative();
    }

    private int parseToInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MONEY_ONLY_NUMBER.getMessage());
        }
    }

    private void validateNegative() {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }

    public void minusMoney(int minus) {
        money -= minus;
    }
}

