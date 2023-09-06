package level2;

import java.util.Arrays;

public class ArrayCutting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ArrayCutting().solution(2, 0, 1)));
    }
    public int[] solution(int k, long left, long right) {
        long n = left==0?1:(long) Math.ceil((double)left/k);
        long m = (long) Math.ceil((double)right/k);
        int length = (int) (m-n+1)*k;
        int[] arr = new int[length];
        int idx = 0;
        for(int i = (int) n; i<=m; i++){
            long count = 0;
            for(int j=i; j<=k; j++){
                while(count!=j){
                    arr[idx] = j;
                    idx++; count++;
                }
            }
        }
        return Arrays.copyOfRange(arr, (int)((left%k)), right%k==0?length:(int)(length-(k-1-(right % k))));
    }
}
