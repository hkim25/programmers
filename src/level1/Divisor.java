package level1;

import java.util.Arrays;

public class Divisor {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr).filter(e->e%divisor==0).sorted().toArray();
        return result.length!=0?result:new int[]{-1};
    }
}
