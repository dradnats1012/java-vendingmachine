package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ConsoleMessage;

public class Output {
    public void vendingMachineCoin(StringBuilder coinList) {

        System.out.println(coinList);
    }

    public void outputCash(String inputCash){
        System.out.println(ConsoleMessage.INPUT_MONEY.getMessage());
        validateMoney(inputCash);

        System.out.println(inputCash);
        System.out.println();
    }

    public void outputMachineMoney(String machineMoney){
        System.out.println(ConsoleMessage.INPUT_VENDINGMACHINE_MONEY.getMessage());

        validateMoney(machineMoney);

        System.out.println(machineMoney);
    }

    private void validateMoney(String money){
        if(!isMoneyInteger(money)){
            throw new IllegalArgumentException(ConsoleMessage.ERROR_MONEY_MUST_INT.getMessage());
        }
        if(multiple10(money)){
            throw new IllegalArgumentException(ConsoleMessage.ERROR_MONEY_MUST_MULTIPLE_10.getMessage());
        }
    }

    private boolean isMoneyInteger(String money) {
        return money.matches("\\d+");
    }


    private boolean multiple10(String money) {
        return ((Integer.parseInt(money) % 10) != 0);
    }

}
