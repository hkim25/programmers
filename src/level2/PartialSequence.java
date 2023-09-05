package level2;

import java.util.HashSet;
import java.util.Set;

public class PartialSequence {
    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 1, 4};
        System.out.println(new PartialSequence().solution(arr));
    }
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int total = 0;
        for(int i : elements){
            total += i;
        }
        set.add(total);
        for(int size = 1; size<elements.length; size++){
            int current = 0;
            for(int i=0; i<elements.length; i++){
                int idx = i;
                int sum = 0;
                while(size>current){
                    sum += elements[idx%elements.length];
                    current++; idx++;
                }
                set.add(sum);
                current = 0;
            }
        }
        return set.size();
    }
}
