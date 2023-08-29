package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SameChar {
    public static void main(String[] args) {
        String s = "foobar";
        System.out.println(Arrays.toString(solution(s)));
    }
    static int[] solution(String s) {
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                result[i] = i - map.get(s.charAt(i));
                map.replace(s.charAt(i),i);
            }else{
                result[i] = -1;
                map.put(s.charAt(i),i);
            }
        }
        return result;
    }
}
