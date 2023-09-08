package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Process {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(new Process().solution(priorities,location));
    }
    public int solution(int[] priorities, int location) {
        int count = 0;
        Stack<Integer> rank = new Stack<>();
        Queue<Integer> process = new LinkedList<>();
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0; i<priorities.length; i++){
            process.add(i);
            index.put(i, priorities[i]);
        }
        for(int i : Arrays.stream(priorities).sorted().toArray()){
            rank.add(i);
        }
        while(true){
            Integer i = process.poll();
            if(index.get(i)>=rank.peek()){
                count++;
                rank.pop();
                if(i==location)return count;
            }else{
                process.add(i);
            }
        }
    }
}
