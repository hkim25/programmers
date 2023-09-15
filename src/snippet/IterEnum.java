package snippet;

public class IterEnum {
    public int solution(int price) {
        double discount = 0.00;
        for(Discount d : Discount.values()){
            if(price>=d.getPrice())discount=d.getRate();
        }
        return (int)Math.floor(price*(1-discount));
    }
}
enum Discount {
    TEN(100000,0.05),
    THIRTY(300000,0.10),
    FIFTY(500000,0.20);

    private final int price;
    private final double rate;

    Discount(int price, double rate){
        this.price = price;
        this.rate = rate;
    }

    public double getRate() {
        return this.rate;
    }
    public int getPrice() {
        return price;
    }
}