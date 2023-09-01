package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveMinValue {
    public static void main(String[] args) {
        int[] arr = {10,10};
        System.out.println(Arrays.toString(new RemoveMinValue().solution(arr)));
    }
    public int[] solution(int[] arr) {
        if(arr.length<=1)return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i!=min)list.add(i);
        }
        int[] result = list.stream().mapToInt(e->e).toArray();
        return result.length!=0?result:new int[]{-1};
    }
}
