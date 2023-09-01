package level1;

import java.util.HashMap;
import java.util.Map;

public class SumLR {
    public static void main(String[] args) {
        System.out.println(new SumLR().solution(24,27));
    }
    public int solution(int left, int right) {
        int result = 0;
        Map<Integer,Integer> map = calculate(right);
        for(int i=left; i<=right; i++){
            int k = map.get(i);
            result += k%2!=0?i*-1:i;
        }
        return result;
    }
    private Map<Integer,Integer> calculate(int n){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            int e = 1;
            for(int j=i; j<=n; j=i*e){
                if(map.containsKey(j)){
                    map.put(j,map.get(j)+1);
                }else{
                    map.put(j,1);
                }
                e++;
            }
        }
        return map;
    }
}
