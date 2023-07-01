package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.ConsoleMessage;
import vendingmachine.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public String inputMachineMoney() {
        String vendingMoney = Console.readLine();
        validateNumber(vendingMoney);
        return vendingMoney;
    }


    public List<Product> inputProduct() {
        System.out.println(ConsoleMessage.INPUT_GOODS.getMessage());
        String input = Console.readLine();

        System.out.println(input);
        System.out.println();

        String[] split = input.split(";");

        List<Product> products = new ArrayList<>();

        for (String s : split) {
            Product product = parseProduct(s);
            products.add(product);
        }

        return products;
    }

    private Product parseProduct(String input) {
        String devideProduct = input.replaceAll("\\[?\\]?", "");
        String[] product = devideProduct.split(",");

        if (product.length != 3) {
            throw new IllegalArgumentException(ConsoleMessage.ERROR_PRODUCT_WRONG.getMessage());
        }
        validateNumber(product[1]);
        validateNumber(product[2]);

        return new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2]));
    }

    private void validateNumber(String price) {
        if (!isPriceInteger(price)) {
            throw new IllegalArgumentException(ConsoleMessage.ERROR_MONEY_MUST_INT.getMessage());
        }
    }

    private boolean isPriceInteger(String price) {
        return price.matches("\\d+");
    }

    public String inputPurchaseProduct() {
        System.out.println(ConsoleMessage.INPUT_GOODS_NAME.getMessage());
        return Console.readLine();
    }

    public String inputCash() {
        return Console.readLine();
    }

    public void remainMoney(int remainMoney) {
        System.out.print(ConsoleMessage.MONEY.getMessage() + ": ");
        System.out.println(remainMoney + "원");
    }
}
