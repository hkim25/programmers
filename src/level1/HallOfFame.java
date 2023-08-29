package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HallOfFame {
    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(Arrays.toString(solution(k, score)));
    }
    static int[] solution(int k, int[] score) {
        boolean isInit = true;
        int[] result = new int[score.length];
        List<Integer> fame = new ArrayList<>();
        for(int i=0; i< score.length; i++){
            if(isInit){
                fame.add(score[i]);
                isInit = fame.size()!=k;
            }else{
                if(score[i]>fame.get(k-1)){
                    fame.remove(k-1);
                    fame.add(score[i]);
                }
            }
            fame.sort(Comparator.reverseOrder());
            result[i] = fame.get(fame.size()-1);
        }
        return result;
    }
}
