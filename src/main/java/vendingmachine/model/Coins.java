package vendingmachine.model;

import static vendingmachine.Coin.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class Coins {

    private final Money money;
    private final List<Integer> coins = Arrays.asList(
        COIN_10.getAmount(), COIN_50.getAmount(), COIN_100.getAmount(), COIN_500.getAmount()
    );

    public Coins(Money money) {
        this.money = money;
        pickCoins();
    }

    private void pickCoins() {
        while (money.getMoney() != 0) {
            int amount = pickCoin();
            caculate(amount);
        }
    }

    private void caculate(int amount) {
        if (money.getMoney() >= amount) {
            money.minusMoney(amount);

            Coin.plusCoin(amount);
        }
    }

    private int pickCoin() {
        return Randoms.pickNumberInList(coins);
    }
}
