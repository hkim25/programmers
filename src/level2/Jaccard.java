package level2;

import java.util.HashMap;
import java.util.Map;

public class Jaccard {
    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";
        System.out.println(new Jaccard().solution(str1,str2));
    }
    public int solution(String str1, String str2) {
        return new Text(str1).calculateJaccard(new Text(str2),65536);
    }
}

class Text {
    private final Map<String,Integer> duplicateSet;

    public Text(String s){
        this.duplicateSet = new HashMap<>();
        initializing(s.toLowerCase().toCharArray(),this.duplicateSet);
    }
    private void initializing(char[] arr, Map<String,Integer> map){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length-1; i++){
            sb.setLength(0);
            if(isAlphabet(arr[i])&&isAlphabet(arr[i+1])){
                sb.append(arr[i]).append(arr[i+1]);
                String s = sb.toString();
                if(map.containsKey(s)){
                    map.put(s, map.get(s)+1);
                }else{
                    map.put(s,1);
                }
            }
        }
    }
    private boolean isAlphabet(char c){
        return c>96&&c<123;
    }
    public Map<String, Integer> getDuplicateSet() {
        return this.duplicateSet;
    }
    public int calculateJaccard(Text other, int coefficient){
        if(this.duplicateSet.isEmpty()&&other.getDuplicateSet().isEmpty())return coefficient;
        int combined = 0;
        int intersection = 0;
        for(String s : this.duplicateSet.keySet()){
            combined += Math.max(this.duplicateSet.get(s),other.getDuplicateSet().getOrDefault(s,0));
            if(other.getDuplicateSet().containsKey(s)){
                intersection += Math.min(this.duplicateSet.get(s),other.getDuplicateSet().get(s));
            }
        }
        for(String s : other.getDuplicateSet().keySet()){
            if(!this.duplicateSet.containsKey(s)){
                combined += other.getDuplicateSet().get(s);
            }
        }
        return (int) Math.floor((double)intersection / (double)combined * coefficient);
    }
}
