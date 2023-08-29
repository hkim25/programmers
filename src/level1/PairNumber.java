package level1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/131128
public class PairNumber {
    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";
        System.out.println(new PairNumber().solution(X,Y));
    }
    public String solution(String X, String Y) {
        char[] xArray = X.toCharArray();
        char[] yArray = Y.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : xArray) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for(char c : yArray){
            if (map.containsKey(c)&&!map.get(c).equals(0)) {
                list.add(c);
                map.put(c,map.get(c)-1);
            }
        }
        list.sort(Comparator.reverseOrder());
        if(list.isEmpty()){
            sb.append("-1");
        }else if(list.get(0)=='0'){
            sb.append("0");
        }else{
            for(Character c : list){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
