package vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void plusCoin(){
        count++;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin getCoin(int amount) {
        Coin result = null;
        for (Coin a : Coin.values()) {
            if (a.getAmount() == amount) {
                result = a;
                break;
            }
        }

        return result;
    }

    public static StringBuilder makeCoinList() {
        StringBuilder sb = new StringBuilder();
        for (Coin coin : Coin.values()) {
            sb.append(coin.getAmount()).append("원 - ").append(coin.getCount()).append("개").append("\n");
        }

        return sb;
    }


}
