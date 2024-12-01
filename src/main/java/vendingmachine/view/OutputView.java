package vendingmachine.view;

import static vendingmachine.util.Message.*;

import java.util.Map;

import vendingmachine.model.dto.ChangeDTO;
import vendingmachine.model.dto.CoinDTO;

public class OutputView {

    public static void printCoin(CoinDTO coinDTO){
        System.out.println(VENDING_MACHINE_COIN.getMessage());
        for (Map.Entry<Integer, Integer> entry : coinDTO.getCoinCount().entrySet()) {
            System.out.printf(VENDING_MACHINE_COIN_COUNT.getMessage() + "\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void printRemainderMoney(int money){
        System.out.println();
        System.out.printf(MONEY.getMessage() + "\n", money);
    }

    public static void printChange(ChangeDTO changeDTO){
        System.out.println(CHANGE.getMessage());
        for (Map.Entry<Integer, Integer> entry : changeDTO.getChanges().entrySet()) {
            System.out.printf(VENDING_MACHINE_COIN_COUNT.getMessage() + "\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void printException(String message){
        System.out.println(message);
    }
}
