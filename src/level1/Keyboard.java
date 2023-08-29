package level1;

import java.util.Arrays;

public class Keyboard {
    public static void main(String[] args) {
        String[] keymap = {"AA"};
        String[] targets = {"B"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }
    static int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        int count;
        for(int i=0; i<targets.length; i++){
            count = 0;
            for(int j=0; j<targets[i].length(); j++){
                String goal = String.valueOf(targets[i].charAt(j));
                int[] countCheck = new int[keymap.length];
                for(int k=0; k<keymap.length; k++){
                    countCheck[k] = keymap[k].indexOf(goal);
                }
                int min = getPositiveMinValueWithZero(countCheck);
                if(min<0){
                    result[i]=-1;
                    break;
                }else{
                    count+=(min+1);
                }
            }
            if(result[i]!=-1){
                result[i] = count;
            }
        }
        return result;
    }
    static int getPositiveMinValueWithZero(int[] array){
        boolean isSkippedAll = true;
        int min = Integer.MAX_VALUE;
        for(int i : array){
            if(i<0)continue;
            min = Math.min(i,min);
            isSkippedAll = false;
        }
        return isSkippedAll?-1:min;
    }
}
