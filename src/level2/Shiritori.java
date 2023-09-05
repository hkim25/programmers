package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Shiritori {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(new Shiritori().solution(2, words3)));
    }
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char recent = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(words[i].startsWith(String.valueOf(recent))&&!set.contains(words[i])){
                recent = words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }else{
                return new int[]{(i+1)%n==0?n:(i+1)%n,(int)Math.ceil((double)(i+1)/(double)n)};
            }
        }
        return new int[]{0,0};
    }
}
