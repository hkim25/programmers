package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mbti {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
    static String solution(String[] survey, int[] choices) {
        Map<String,Integer> map = new HashMap<>();
        map.put("R",0);map.put("T",0);
        map.put("C",0);map.put("F",0);
        map.put("J",0);map.put("M",0);
        map.put("A",0);map.put("N",0);
        choices = Arrays.stream(choices).map(i->i-4).toArray();
        for(int i=0; i<survey.length; i++){
            String s = survey[i].substring(1);
            map.replace(s,(map.get(s)+choices[i]));
        }
        return String.format(
                "%s%s%s%s",
                map.get("R")>=map.get("T")?"R":"T",
                map.get("C")>=map.get("F")?"C":"F",
                map.get("J")>=map.get("M")?"J":"M",
                map.get("A")>=map.get("N")?"A":"N"
        );
    }
}
