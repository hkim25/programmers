package level1;

import java.util.HashMap;
import java.util.Map;

public class Knight {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(new Knight().solution(number,limit,power));
    }
    public int solution(int number, int limit, int power) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int x;
        for(int i=1; i<=number; i++){
            map.put(i,1);
        }
        for(int i=2; i<=number; i++){
            x = 1;
            for(int j=i; j<=number; j=x*i){
                map.put(j,map.get(j)+1);
                x++;
            }
        }
        for(Integer i : map.keySet()){
            if(map.get(i)>limit){
                result += power;
            }else{
                result += map.get(i);
            }
        }
        return result;
    }
}
