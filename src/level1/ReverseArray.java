package level1;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReverseArray().solution(12345)));
    }
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        int idx = s.length()-1;
        for(char c : s.toCharArray()){
            arr[idx] = c-48;
            idx--;
        }
        return arr;
    }
}
