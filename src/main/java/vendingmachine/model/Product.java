package vendingmachine.model;

import vendingmachine.util.ConsoleMessage;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, int price, int amount) {
        validatePrice(price);
        validateAmount(amount);
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void minusAmount() {
        amount--;
    }

    public void purchase() {
        if (!lessThan0(amount)) {
            amount--;
        }
    }

    private void validateAmount(int amount) {
        if (lessThan0(amount)) {
            throw new IllegalArgumentException(ConsoleMessage.ERROR_AMOUNT_MORE_0.getMessage());
        }
    }

    private boolean lessThan0(int amount) {
        return amount <= 0;
    }

    private void validatePrice(int price) {
        if (lessThan100(price)) {
            throw new IllegalArgumentException(ConsoleMessage.ERROR_GOODS_MUST_MORE_100.getMessage());
        }
        if (multiple10(price)) {
            throw new IllegalArgumentException(ConsoleMessage.ERROR_GOODS_MUST_MULTIPLE_10.getMessage());
        }
    }

    private boolean lessThan100(int price) {
        return price < 100;
    }

    private boolean multiple10(int price) {
        return (price % 10) != 0;
    }
}
