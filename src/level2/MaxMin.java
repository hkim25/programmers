package level2;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        System.out.println(new MaxMin().solution("-1 -2 -3 -4"));
    }
    public String solution(String s) {
        int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        return String.format("%d %d",array[0],array[array.length-1]);
    }
}
