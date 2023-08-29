package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dog {
    public static void main(String[] args) {
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }
    static int[] solution(String[] park, String[] routes) {
        Map<String, Boolean> map = new HashMap<>();
        int[] location = new int[0];
        int maxLength = park[0].length()-1;
        int maxWidth = park.length-1;

        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                map.put(String.format("(%s,%s)",i,j), park[i].charAt(j)!='X');
                if(park[i].charAt(j)=='S')location=new int[]{i,j};
            }
        }

        for(String s : routes){
            String[] array = s.split(" ");
            String way = array[0];
            int distance = Integer.parseInt(array[1]);
            switch (way){
                case"E":
                    if(location[1]+distance>maxLength)continue;
                    for(int i=1; i<distance+1; i++){
                        if(!map.get(String.format("(%s,%s)",location[0],location[1]+i))){
                            distance = 0;
                            break;
                        }
                    }
                    location[1]+=distance;
                    break;
                case"S":
                    if(location[0]+distance>maxWidth)continue;
                    for(int i=1; i<distance+1; i++){
                        if(!map.get(String.format("(%s,%s)",location[0]+i,location[1]))){
                            distance = 0;
                            break;
                        }
                    }
                    location[0]+=distance;
                    break;
                case"W":
                    if(location[1]-distance<0)continue;
                    for(int i=1; i<distance+1; i++){
                        if(!map.get(String.format("(%s,%s)",location[0],location[1]-i))){
                            distance = 0;
                            break;
                        }
                    }
                    location[1]-=distance;
                    break;
                case"N":
                    if(location[0]-distance<0)continue;
                    for(int i=1; i<distance+1; i++){
                        if(!map.get(String.format("(%s,%s)",location[0]-i,location[1]))){
                            distance = 0;
                            break;
                        }
                    }
                    location[0]-=distance;
                    break;
            }
        }
        return location;
    }
}
