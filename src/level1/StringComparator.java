package level1;

import java.util.Arrays;

public class StringComparator {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        System.out.println(Arrays.toString(new StringComparator().solution(strings, n)));
    }
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((s1, s2) -> {
            int result = 0;
            char[] a1 = s1.toCharArray();
            char[] a2 = s2.toCharArray();
            if(a1[n]!=a2[n]){
                result = a1[n]-a2[n];
            }else{
                for(int i=0; i<a1.length; i++){
                    try{
                        if(a1[i]!=a2[i]){
                            result = a1[i]-a2[i];
                            break;
                        }
                    }catch(ArrayIndexOutOfBoundsException e){
                        result = a1.length-a2.length;
                    }
                }
            }
            return result;
        }).toArray(String[]::new);
    }
}
