package level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class ReportUser {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> result = new HashMap<>();
        Map<String, Set<String>> reported = new HashMap<>();
        for(String s : id_list){
            result.put(s,0);
            reported.put(s,new HashSet<>());
        }
        for(String s : report){
            String[] split = s.split(" ");
            reported.get(split[1]).add(split[0]);
        }
        for(String s : id_list){
            if(reported.get(s).size()>=k){
                for(String id : reported.get(s)){
                    result.replace(id,result.get(id)+1);
                }
            }
        }
        for(int i=0; i<id_list.length; i++){
            answer[i] = result.get(id_list[i]);
        }
        return answer;
    }
}
