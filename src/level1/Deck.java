package level1;

import java.util.Arrays;

public class Deck {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1,cards2,goal));
    }
    static String solution(String[] cards1, String[] cards2, String[] goal) {
        int[] iter = {0,0};
        for(String s : goal){
            try{
                if(cards1[iter[0]].equals(s)){
                    iter[0]++;continue;
                }
            }catch(IndexOutOfBoundsException ignored){
            }
            try{
                if(cards2[iter[1]].equals(s)){
                    iter[1]++;continue;
                }
            }catch (IndexOutOfBoundsException ignored){
            }
            return "No";
        }
        return "Yes";
    }
}
