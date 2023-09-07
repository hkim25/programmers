package level2;

import java.util.*;

public class Tp {
    public static void main(String[] args) {
        String s = "{{123}}";
        System.out.println(Arrays.toString(new Tp().solution(s)));
    }
    public int[] solution(String s) {
        Map<Integer,String[]> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        String[] split = s.replaceAll("},\\{","^").replaceAll("}","").replaceAll("\\{","").split("\\^");
        for(String ele : split){
            String[] eleSplit = ele.split(",");
            map.put(eleSplit.length, eleSplit);
        }
        for(int i=1; map.containsKey(i); i++){
            for(String ele : map.get(i)){
                if(!set.contains(ele)){
                    list.add(Integer.parseInt(ele));
                    set.add(ele);
                }
            }
        }
        return list.stream().mapToInt(e->e).toArray();
    }
}
