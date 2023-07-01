package vendingmachine.model;

import vendingmachine.Coin;

public class Change {
    public StringBuilder lessThanLeftMoney(int leftMoney, int machineMoney) {
        StringBuilder sb = new StringBuilder();
        if (leftMoney > machineMoney) {
            for (Coin coin : Coin.values()) {
                if (coin.getCount() != 0) {
                    sb.append(coin.getAmount()).append("원 - ").append(coin.getCount()).append("개").append("\n");
                }
            }
        }
        return sb;
    }

}
