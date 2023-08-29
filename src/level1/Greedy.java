package level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Greedy {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(new Greedy().solution(n,lost,reserve));
    }
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> status = new HashMap<>();
        Set<Integer> keySet;
        int prev;
        int next;
        int poor = 0;

        for(int i=1; i<=n; i++){
            status.put(i,1);
        }
        keySet = status.keySet();

        for(int i : lost){
            status.put(i,status.get(i)-1);
        }
        for(int i : reserve){
            status.put(i,status.get(i)+1);
        }

        for(Integer key : keySet){
            try{
                next = status.get(key+1);
            }catch(NullPointerException ignored){
                next = 0;
            }
            try{
                prev = status.get(key-1);
            }catch(NullPointerException ignored){
                prev = 0;
            }
            if(status.get(key).equals(0)){
                if(prev>1){
                    status.put(key-1,status.get(key-1)-1);
                    status.put(key,1);
                }else{
                    if(next>1){
                        status.put(key+1,status.get(key+1)-1);
                        status.put(key,1);
                    }else{
                        poor++;
                    }
                }
            }
        }
        return n-poor;
    }
}
