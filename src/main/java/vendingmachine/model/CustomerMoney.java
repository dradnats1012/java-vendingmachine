package vendingmachine.model;

import static vendingmachine.util.ErrorMessage.ERROR_MONEY_ONLY_NUMBER;
import static vendingmachine.util.ErrorMessage.ERROR_NEGATIVE;

public class CustomerMoney {

    private int customerMoney;

    public CustomerMoney(String inputMoney) {
        this.customerMoney = parseToInteger(inputMoney);
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
        if (customerMoney < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE.getMessage());
        }
    }

    public int getMoney() {
        return customerMoney;
    }

    public void minusMoney(int minus) {
        customerMoney -= minus;
    }
}

