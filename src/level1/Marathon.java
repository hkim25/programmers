package level1;

import java.util.HashMap;
import java.util.Map;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa", "marina"};
        String[] completion = {"josipa", "filipa", "marina", "nikola", "vinko"};
        System.out.println(new Marathon().solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String result = null;
        Map<String, Integer> comMap = new HashMap<>();
        for(String s : completion){
            if(comMap.containsKey(s)){
                comMap.put(s,comMap.get(s)+1);
            }else{
                comMap.put(s,1);
            }
        }
        for(String s : participant){
            if (comMap.containsKey(s)) {
                if(comMap.get(s).equals(0)){
                    result = s;
                    break;
                }else{
                    comMap.put(s,comMap.get(s)-1);
                }
            } else {
                result = s;
                break;
            }
        }
        return result;
    }
}
