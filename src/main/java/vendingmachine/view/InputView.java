package vendingmachine.view;

import static vendingmachine.util.Message.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputVendingMachineMoney() {
        System.out.println(INPUT_VENDING_MACHINE_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputGoods() {
        System.out.println(INPUT_GOODS.getMessage());
        return Console.readLine();
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
        return Console.readLine();
    }

    public static String purchaseGoods() {
        System.out.println(PURCHASE_GOODS);
        return Console.readLine();
    }
}
