package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deployment {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new Deployment().solution(progresses, speeds)));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int index = 0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        while(true){
            int count = 0;
            for(int i=index; i<progresses.length; i++){
                progresses[i]+=speeds[i];
            }
            for(int i=index; i<progresses.length; i++){
                if(progresses[i]<100){
                    index = i;
                    break;
                }else{
                    count++;
                }
            }
            if(count!=0){
                list.add(count);
                total += count;
                if(total==progresses.length)return list.stream().mapToInt(e->e).toArray();
            }
        }
    }
}
