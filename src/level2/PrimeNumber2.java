package level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumber2 {
    public static void main(String[] args) {
        System.out.println(new PrimeNumber2().solution(110011,10));
    }
    public int solution(int n, int k) {
        int result = 0;
        List<Long> list = Arrays.stream(decimalConversion(n,k).split("0+")).mapToLong(Long::parseLong).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(!list.isEmpty()){
            int range = list.contains((long)1)?list.indexOf((long)1):list.size();
            for(int i=0; i<range; i++){
                if(isPrimeNumber(list.get(i)))result++;
            }
        }
        return result;
    }
    private String decimalConversion(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.insert(0,n%k);
            n /= k;
        }
        return sb.toString();
    }
    private boolean isPrimeNumber(long n){
        boolean result = true;
        if(n!=2){
            for(int i=2; i<Math.sqrt(n)+1; i++){
                if(n%i==0) return false;
            }
        }
        return result;
    }
}
