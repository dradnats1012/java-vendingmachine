package vendingmachine.model;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.goods.Goods;
import vendingmachine.util.Parser;

public class VendingMachine {

    private final Money money;
    private final Coins coins;
    private final List<Goods> goods;

    public VendingMachine(Money money, Coins coins, String inputGoods) {
        this.money = money;
        this.coins = coins;
        this.goods = makeGoods(inputGoods);
    }

    private List<Goods> makeGoods(String inputGoods) {
        return Parser.parseAllGoods(inputGoods).stream()
            .map(goodsData -> new Goods(
                goodsData.get(0),
                goodsData.get(1),
                goodsData.get(2)
            ))
            .collect(Collectors.toList());
    }

    public void purchaseGoods(String purchaseGoodsName, CustomerMoney customerMoney) {
        goods.stream().filter(good -> purchaseGoodsName.equals(good.getName()))
            .forEach(good -> {
                good.minusAmount();
                customerMoney.minusMoney(good.getPrice());
            });
    }

    public boolean isEnd(CustomerMoney customerMoney) {
        return isAllGoodsEmpty() || isChangeLessThanPrice(customerMoney);
    }

    private boolean isAllGoodsEmpty() {
        return goods.stream().allMatch(oneGoods -> oneGoods.getAmount() == 0);
    }

    private boolean isChangeLessThanPrice(CustomerMoney customerMoney) {
        return goods.stream().allMatch(oneGoods -> oneGoods.getPrice() > customerMoney.getMoney());
    }

    public int getMoney() {
        return money.getMoney();
    }
}
