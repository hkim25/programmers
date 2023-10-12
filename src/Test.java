import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(new Test().solution(numbers)));
    }

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(idx<numbers.length){
            int ele = -1;
            for(int i=idx+1; i< numbers.length; i++){
                if(numbers[i]>numbers[idx]){
                    ele = numbers[i];
                    break;
                }
            }
            list.add(ele);
            idx++;
        }
        return list.stream().mapToInt(e->e).toArray();
    }
}