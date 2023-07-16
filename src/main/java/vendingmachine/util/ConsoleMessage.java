package vendingmachine.util;

public enum ConsoleMessage {
    INPUT_VENDINGMACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    OUTPUT_VENDINGMACHINE_COIN("자판기가 보유한 동전"),
    INPUT_GOODS("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_GOODS_NAME("구매할 상품명을 입력해 주세요."),
    CHANGE("잔돈"),
    ERROR_MONEY_MUST_INT("[ERROR] 금액은 숫자여야 합니다."),
    ERROR_MONEY_MUST_MULTIPLE_10("[ERROR] 금액은 10원으로 나누어 떨어져야 합니다"),
    ERROR_GOODS_MUST_MORE_100("[ERROR] 가격은 100원 이상이어야 합니다."),
    ERROR_GOODS_MUST_MULTIPLE_10("[ERROR] 가격은 10원으로 나누어 떨어져야 합니다."),
    ERROR_AMOUNT_MORE_0("[ERROR] 수량은 0보다 많아야 합니다."),
    ERROR_PRODUCT_WRONG("[ERROR] 상품의 형식이 잘못되었습니다."),
    INPUT_MONEY("투입 금액을 입력해 주세요."),
    INPUT_MONEY_MUST_NATURAL("[ERROR] 투입 금액은 자연수여야 합니다."),
    MONEY("투입 금액"),
    GOODS_NOT_EXIST("[ERROR] 상품이 존재하지 않습니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
