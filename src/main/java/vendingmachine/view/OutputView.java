package vendingmachine.view;

import static vendingmachine.util.Message.CHANGE;
import static vendingmachine.util.Message.VENDING_MACHINE_COIN;

public class OutputView {

    public static void printCoin(){
        System.out.println(VENDING_MACHINE_COIN.getMessage());

    }

    public static void printChange(){
        System.out.println(CHANGE.getMessage());

    }
}
