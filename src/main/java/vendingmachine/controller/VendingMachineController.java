package vendingmachine.controller;

import vendingmachine.Coin;
import vendingmachine.util.ConsoleMessage;
import vendingmachine.model.Change;
import vendingmachine.model.Product;
import vendingmachine.model.RandomCoin;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.List;
import java.util.Objects;

public class VendingMachineController {
    private final Input input;
    private final Output output;
    private int cash;

    public VendingMachineController() {
        this.input = new Input();
        this.output = new Output();
    }

    public void run() {
        RandomCoin randomCoin = new RandomCoin();
        Change change = new Change();

        int machineMoney = insertMachineMoney();

        makeRandomCoin(randomCoin, machineMoney);

        List<Product> productList = operateMachine();

        purchase(productList);
        System.out.println(ConsoleMessage.CHANGE.getMessage());

        checkChange(change, machineMoney);
    }

    private List<Product> operateMachine() {
        List<Product> productList = input.inputProduct();
        String inputCash = input.inputCash();
        output.outputCash(inputCash);
        cash = Integer.parseInt(inputCash);
        return productList;
    }

    private void makeRandomCoin(RandomCoin randomCoin, int machineMoney) {
        randomCoin.makeRandomCoin(machineMoney);
        System.out.println(ConsoleMessage.OUTPUT_VENDINGMACHINE_COIN.getMessage());
        output.vendingMachineCoin(Coin.makeCoinList());
    }

    private int insertMachineMoney() {
        String machinemoney = input.inputMachineMoney();
        output.outputMachineMoney(machinemoney);
        int machineMoney = Integer.parseInt(machinemoney);
        System.out.println();
        return machineMoney;
    }

    private void checkChange(Change change, int machineMoney) {
        if (machineMoney > cash) {
            output.vendingMachineCoin(change.overLeftMoney(cash, machineMoney));
        }
        if (machineMoney < cash) {
            output.vendingMachineCoin(change.belowLeftMoney(cash, machineMoney));
        }
    }

    private void purchase(List<Product> productList) {
        while (true) {
            input.remainMoney(cash);

            if (!comparePrice(productList)) {
                break;
            }

            purchaseProduct(productList);
        }
    }

    private void purchaseProduct(List<Product> productList) {
        String productName = input.inputPurchaseProduct();

        if (checkProduct(productList, productName)) {
            System.out.println(productName);
            System.out.println();
        }
    }

    private boolean comparePrice(List<Product> productList) {
        int minimum = cash;
        for (Product product : productList) {
            if (product.getPrice() < minimum) {
                minimum = product.getPrice();
            }
        }

        return cash != minimum;
    }

    private boolean checkProduct(List<Product> productList, String productName) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productName)) {
                cash -= product.getPrice();
                product.minusAmount();
                return true;
            }
        }
        throw new IllegalArgumentException(ConsoleMessage.GOODS_NOT_EXIST.getMessage());
    }
}
