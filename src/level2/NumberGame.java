package level2;

import java.util.HashMap;
import java.util.Map;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println(new NumberGame().solution(16,16,2,2));
    }
    public String solution(int n, int t, int m, int p) {
        return new NumberCalculator(n,t,m).getResult(p);
    }
}

class NumberCalculator {
    private final int quantity;
    private final int member;
    private final StringBuilder converter;
    private final StringBuilder number;
    private final Map<Integer, String> numberMap;
    public NumberCalculator(int k, int quantity, int member){
        this.quantity = quantity;
        this.member = member;
        this.converter = new StringBuilder();
        this.number = new StringBuilder();
        if(k>10){
            this.numberMap = new HashMap<>();
            for(int i=0; i<10; i++){
                this.numberMap.put(i,String.valueOf(i));
            }
            for(int i=10; i<=k; i++){
                this.numberMap.put(i,String.valueOf((char)(i+55)));
            }
        }else{
            this.numberMap = null;
        }
        for(int i=0; this.number.length()<quantity*member; i++){
            this.number.append(decimalConversion(i,k));
        }
    }
    private String decimalConversion(int n, int k){
        if(n==0)return "0";
        this.converter.setLength(0);
        while(n>0){
            this.converter.insert(0,this.numberMap!=null?this.numberMap.get(n%k):n%k);
            n /= k;
        }
        return this.converter.toString();
    }
    public String getResult(int sequence){
        StringBuilder result = new StringBuilder();
        for(int i=sequence; i<=this.quantity*this.member; i+=this.member){
            result.append(this.number.charAt(i-1));
        }
        return result.toString();
    }
}
