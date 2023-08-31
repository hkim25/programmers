package level1;

public class Money {
    public static void main(String[] args) {
        System.out.println(new Money().solution(3,20,4));
    }
    public long solution(int price, int money, int count) {
        long payment = (long) price *count*(1+count)/2;
        return payment>money?payment-money:0;
    }
}
