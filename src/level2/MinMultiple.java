package level2;

import java.util.Arrays;

public class MinMultiple {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        System.out.println(new MinMultiple().solution(A,B));
    }
    public int solution(int[] A, int[] B) {
        int result = 0;
        int length = A.length;
        int[] a = Arrays.stream(A).sorted().toArray();
        int[] b = Arrays.stream(B).sorted().toArray();
        for(int i=0; i<length; i++){
            result += a[i]*b[length-1-i];
        }
        return result;
    }
}
