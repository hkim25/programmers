package level2;

import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {
        int[] arr = {70,10,50,79,54,12,55,87,12,98,12,80,99,110,210,140};
        System.out.println(new Greedy().solution(arr,220));
    }
    public int solution(int[] people, int limit) {
        int result = 0;
        int light = 0;
        int weight = 0;
        people = Arrays.stream(people).sorted().toArray();
        for (int heavy=people.length-1; heavy>=light; heavy--) {
            weight += people[heavy];
            if(light<heavy&&weight+people[light]<=limit){
                light++;
            }
            weight = 0;
            result++;
        }
        return result;
    }
}
