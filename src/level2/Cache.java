package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(new Cache().solution(cacheSize,cities));
    }
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0)return cities.length*5;
        int result = 0;
        Queue<String> queue = new LinkedList<>();
        int idx = 0;
        while(cacheSize>queue.size()){
            String s = cities[idx].toLowerCase();
            if(queue.contains(s)){
                queue.remove(s);
                result += 1;
            }else{
                result += 5;
            }
            queue.add(cities[idx].toLowerCase());
            idx++;
        }
        for(int i=idx; i<cities.length; i++){
            String s = cities[i].toLowerCase();
            if(queue.contains(s)){
                queue.remove(s);
                result += 1;
            }else{
                queue.poll();
                result += 5;
            }
            queue.add(s);
        }
        return result;
    }
}
