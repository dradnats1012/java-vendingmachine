package vendingmachine.model;

import vendingmachine.Coin;

public class Change {
    public StringBuilder belowLeftMoney(int leftMoney, int machineMoney) {
        StringBuilder sb = new StringBuilder();

        if (leftMoney >= machineMoney) {
            for (Coin coin : Coin.values()) {
                printChange(sb, coin);
            }
        }
        return sb;
    }

    public StringBuilder overLeftMoney(int leftMoney, int machineMoney) {
        StringBuilder changes = new StringBuilder();
        int nowChange = 0;
        if (leftMoney < machineMoney) {
            checkChangeMachinemoney(machineMoney, changes, nowChange);
        }
        return changes;
    }

    private void checkChangeMachinemoney(int machineMoney, StringBuilder changes, int nowChange) {
        for (Coin coin : Coin.values()) {
            nowChange += coin.getAmount() * coin.getCount();
            if (nowChange == machineMoney) break;

            printChange(changes, coin);
        }
    }

    private void printChange(StringBuilder changes, Coin coin) {
        if (coin.getCount() != 0) {
            changes.append(coin.getAmount()).append("원 - ").append(coin.getCount()).append("개").append("\n");
        }
    }
}
