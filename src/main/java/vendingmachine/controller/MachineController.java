package vendingmachine.controller;

import vendingmachine.model.Change;
import vendingmachine.model.Coins;
import vendingmachine.model.CustomerMoney;
import vendingmachine.model.Money;
import vendingmachine.model.VendingMachine;
import vendingmachine.model.dto.ChangeDTO;
import vendingmachine.model.dto.CoinDTO;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

    private Money money;
    private Coins coins;
    private VendingMachine vendingMachine;
    private CustomerMoney customerMoney;
    private Change change;

    public void run() {
        process(this::getVendingMachineMoney);
        process(this::getVendingMachine);
        process(this::getCustomerMoney);
        process(this::purchaseGoods);
        makeChange();
        printResult(change);
    }

    private void makeChange() {
        change = new Change(vendingMachine, coins, customerMoney);
        change.makeChange();
    }

    private void printResult(Change change) {
        OutputView.printRemainderMoney(customerMoney.getMoney());
        OutputView.printChange(ChangeDTO.from(change));
    }

    private void getCustomerMoney() {
        customerMoney = new CustomerMoney(InputView.inputMoney());
    }

    private void getVendingMachine() {
        String inputGoods = InputView.inputGoods();
        vendingMachine = new VendingMachine(money, coins, inputGoods);
    }

    private void getVendingMachineMoney() {
        money = new Money(InputView.inputVendingMachineMoney());
        coins = new Coins(money);
        OutputView.printCoin(new CoinDTO());
    }

    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            process(action);
        }
    }

    private void purchaseGoods() {
        while (!vendingMachine.isEnd(customerMoney)) {
            OutputView.printRemainderMoney(customerMoney.getMoney());
            vendingMachine.purchaseGoods(InputView.purchaseGoods(), customerMoney);
        }
    }
}
