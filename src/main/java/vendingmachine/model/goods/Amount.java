package vendingmachine.model.goods;

import static vendingmachine.util.ErrorMessage.ERROR_AMOUNT_ONLY_NUMBER;
import static vendingmachine.util.ErrorMessage.ERROR_NEGATIVE;

public class Amount {

    private int amount;

    public Amount(String inputAmount) {
        this.amount = parseToInteger(inputAmount);
        validateNegative(amount);
    }

    private int parseToInteger(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_AMOUNT_ONLY_NUMBER.getMessage());
        }
    }

    private void validateNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

    public void minusAmount() {
        amount--;
    }
}
