package level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Tangerine {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(new Tangerine().solution(4,arr));
    }
    public int solution(int k, int[] tangerine) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int i :map.values().stream().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray()){
            if(k>0){
                count++; k-=i;
            }else{
                break;
            }
        }
        return count;
    }
}
