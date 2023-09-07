package level2;

import java.util.HashMap;
import java.util.Map;

public class Clothe {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"yellow_hat", "headgear"},{"a","a"},{"a","a"},{"b","b"},{"b","b"},{"b","b"},{"c","c"},{"c","c"}};
        System.out.println(new Clothe().solution(clothes));
    }
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        int result = 1;
        for(String[] arr : clothes){
            if(map.containsKey(arr[1])){
                map.put(arr[1],map.get(arr[1])+1);
            }else{
                map.put(arr[1],1);
            }
        }
        for(String k : map.keySet()){
            result *= map.get(k)+1;
        }
        return result-1;
    }
}
