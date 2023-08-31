package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deduplicate {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(new Deduplicate().solution(arr)));
    }
    public int[] solution(int[] arr){
        List<Integer> list = new ArrayList<>();
        int recent = -1;
        for(int i : arr){
            if(i!=recent){
                list.add(i);
                recent = i;
            }
        }
        return list.stream().mapToInt(e->e).toArray();
    }
}
