package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

import java.util.Arrays;
import java.util.List;

public class RandomCoin {
    public void makeRandomCoin(int money) {
        List<Integer> moneyList = Arrays.asList(500, 100, 50, 10);

        while (money != 0) {
            int num = Randoms.pickNumberInList(moneyList);
            if (money - num >= 0) {
                money -= num;
                Coin.getCoin(num).plusCoin();
            }
        }
    }

}
