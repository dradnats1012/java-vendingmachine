package vendingmachine.util;

public enum Message {

    INPUT_VENDING_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    VENDING_MACHINE_COIN("자판기가 보유한 동전"),
    VENDING_MACHINE_COIN_COUNT("%d원 - %d개"),
    INPUT_GOODS("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY("투입 금액을 입력해 주세요."),
    PURCHASE_GOODS("구매할 상품명을 입력해 주세요."),
    MONEY("투입 금액: %d원"),
    CHANGE("잔돈");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
