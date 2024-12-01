package vendingmachine.model.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.Coin;

public class CoinDTO {

    private final Map<Integer, Integer> coinCount = new LinkedHashMap<>();

    public CoinDTO(){
        makeCoin();
    }

    private void makeCoin(){
        for(Coin coin : Coin.values()){
            coinCount.put(coin.getAmount(), coin.getCount());
        }
    }

    public Map<Integer, Integer> getCoinCount(){
        return coinCount;
    }
}
