package vendingmachine.model.goods;

import static vendingmachine.util.ErrorMessage.*;

public class Price {

    private final int price;

    public Price(String inputPrice) {
        this.price = parseToInteger(inputPrice);
        validatePrice(price);
    }

    private int parseToInteger(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PRICE_ONLY_NUMBER.getMessage());
        }
    }

    private void validatePrice(int price) {
        validateNegative(price);
        validateMore100(price);
        validateUnit10(price);
    }

    private void validateNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE.getMessage());
        }
    }

    private void validateMore100(int money) {
        if (money < 100) {
            throw new IllegalArgumentException(ERROR_PRICE_MORE_THAN_100.getMessage());
        }
    }

    private void validateUnit10(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException(ERROR_PRICE_UNIT_10.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }
}
