package level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(new Budget().solution(d,budget));
    }
    public int solution(int[] d, int budget) {
        int count = 0;
        for(int i : Arrays.stream(d).sorted().toArray()){
            budget-=i;
            if(budget<0)break;
            count++;
        }
        return count;
    }
}
