package vendingmachine.util;

public enum ErrorMessage {

    ERROR_MONEY_ONLY_NUMBER("금액은 숫자여야 합니다."),
    ERROR_PRICE_MORE_THAN_100("가격은 100원 이상이어야 합니다."),
    ERROR_PRICE_UNIT_10("가격은 10원 단위이어야 합니다."),
    ERROR_PRICE_ONLY_NUMBER("가격은 숫자여야 합니다."),
    ERROR_NEGATIVE("양수를 입력해주세요."),
    ERROR_AMOUNT_ONLY_NUMBER("수량은 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
