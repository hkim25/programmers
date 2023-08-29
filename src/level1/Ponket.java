package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ponket {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(new Ponket().solution(nums));
    }
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        return Math.min(set.size(), nums.length/2);
    }
}
