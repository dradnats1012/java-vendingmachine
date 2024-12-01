package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.Coin;

public class Change {

    private final VendingMachine vendingMachine;
    private final Coins coins;
    private final CustomerMoney customerMoney;
    private final Map<Integer, Integer> changes = new LinkedHashMap<>();

    public Change(VendingMachine vendingMachine, Coins coins, CustomerMoney customerMoney) {
        this.vendingMachine = vendingMachine;
        this.coins = coins;
        this.customerMoney = customerMoney;
    }

    public void makeChange() {
        if (customerMoney.getMoney() > vendingMachine.getMoney()) {
            for (Coin coin : Coin.values()) {
                if (customerMoney.getMoney() > coin.getAmount())
                    changes.put(coin.getAmount(), coin.getCount());
            }
            return;
        }

        for (Coin coin : Coin.values()) {
            while (customerMoney.getMoney() > coin.getAmount()) {
                if (customerMoney.getMoney() > coin.getAmount())
                    changes.put(coin.getAmount(), changes.isEmpty() ? 0 : changes.get(coin.getAmount()) + 1);
            }
        }
    }

    public Map<Integer, Integer> getChanges() {
        return changes;
    }
}
