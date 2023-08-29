package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Run {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0; i< players.length; i++){
            rank.put(players[i],i);
        }
        for (String name : callings) {
            String temp;
            int oldRank = rank.get(name);
            temp = players[oldRank - 1];
            players[oldRank - 1] = name;
            players[oldRank] = temp;
            rank.replace(name, oldRank - 1);
            rank.replace(temp, oldRank);
        }
        return players;
    }
}
