package level1;

import java.util.*;

public class Privacy {
    final int MONTH = 28;
    final int YEAR = MONTH*12;

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(new Privacy().solution(today,terms,privacies)));
    }
    int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> resultList = new ArrayList<>();
        int intToday = parsingDate(today);
        Map<String,Integer> map = new HashMap<>();
        for(String s : terms){
            String[] split = s.split(" ");
            map.put(split[0],parsingPeriod(split[1]));
        }
        for(int i=0; i<privacies.length; i++){
            String[] split = privacies[i].split(" ");
            if(intToday >= parsingDate(split[0]) + map.get(split[1])){
                resultList.add(i+1);
            }
        }
        int[] answer = new int[resultList.size()];
        for(int i=0; i< resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    int parsingDate(String date){
        String[] split = date.split("\\.");
        return (this.YEAR*Integer.parseInt(split[0]))+(this.MONTH*Integer.parseInt(split[1]))+Integer.parseInt(split[2]);
    }
    int parsingPeriod(String period){
        return Integer.parseInt(period)*this.MONTH;
    }
}
