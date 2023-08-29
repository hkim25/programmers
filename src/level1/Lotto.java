package level1;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(new Lotto().solution(lottos, win_nums)));
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int matches = 0;
        int unknown = 0;
        for(int i : lottos){
            if(i==0){unknown++;continue;}
            for(int j : win_nums){
                if(i==j)matches++;
            }
        }
        return new int[]{rankCal(matches+unknown),rankCal(matches)};
    }
    int rankCal(int score){
        int result;
        switch(score){
            case 6 : result=1;break;
            case 5 : result=2;break;
            case 4 : result=3;break;
            case 3 : result=4;break;
            case 2 : result=5;break;
            default : result=6;break;
        }
        return result;
    }
}
