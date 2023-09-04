package level2;

import java.math.BigDecimal;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Fibonacci().solution(100000));
    }
    public int solution(int n) {
        BigDecimal[] arr = new BigDecimal[]{BigDecimal.ZERO,BigDecimal.ONE};
        for(int i=2; i<=n; i++){
            BigDecimal temp = arr[1];
            arr[1] = arr[0].add(arr[1]);
            arr[0] = temp;
        }
        BigDecimal result = arr[1].remainder(new BigDecimal("1234567"));
        return result.intValue();
    }
}
