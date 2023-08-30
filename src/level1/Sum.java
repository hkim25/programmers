package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sum {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(new Sum().solution(numbers)));
    }
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(!list.contains(numbers[i] + numbers[j])){
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        return  list.stream().sorted().flatMapToInt(IntStream::of).toArray();
    }
}
