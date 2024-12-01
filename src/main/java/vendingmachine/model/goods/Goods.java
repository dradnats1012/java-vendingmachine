package vendingmachine.model.goods;

public class Goods {

    private final String name;
    private final Price price;
    private final Amount amount;

    public Goods(String name, String price, String amount){
        this.name = name;
        this.price = new Price(price);
        this.amount = new Amount(amount);
    }

    public void minusAmount(){
        amount.minusAmount();
    }

    public int getAmount(){
        return amount.getAmount();
    }

    public int getPrice(){
        return price.getPrice();
    }

    public String getName(){
        return name;
    }
}
