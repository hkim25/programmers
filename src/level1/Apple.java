package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apple {
    public static void main(String[] args) {
        System.out.println(new Apple().solution(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
    public int solution(int k, int m, int[] score) {
        int result = 0;
        int[] sorted = Arrays.stream(score).sorted().toArray();
        for(int i=sorted.length-m; true; i-=m){
            try{
                result += sorted[i]*m;
            }catch(ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        return result;
    }
}
