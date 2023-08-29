package level1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FailRate {
    public static void main(String[] args) {
        int N = 8;
        int[] stages = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(new FailRate().solution(N, stages)));;
    }
    public int[] solution(int N, int[] stages) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, BigDecimal> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (int stage : stages) {
            map.put(stage, map.containsKey(stage)?map.get(stage)+1:1);
        }
        for(int i=N+1; i>0; i--){
            int fail = map.getOrDefault(i, 0);
            total += fail;
            try{
                map2.put(i,new BigDecimal(fail).divide(new BigDecimal(total),MathContext.DECIMAL64));
            }catch(ArithmeticException e){
                map2.put(i,BigDecimal.ZERO);
            }
        }
        map2.remove(N+1);
        Stream<Map.Entry<Integer,BigDecimal>> sorted = map2.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        sorted.forEach(val->list.add(val.getKey()));
        return listToArray(list);
    }

    int[] listToArray(List<Integer> list){
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
