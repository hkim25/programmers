package level1;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(new SecretMap().solution(n, arr1, arr2)));
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        String[] s1 = Arrays.stream(arr1).mapToObj(i->decimalToBinaryString(i,n)).toArray(String[]::new);
        String[] s2 = Arrays.stream(arr2).mapToObj(i->decimalToBinaryString(i,n)).toArray(String[]::new);
        for(int i=0; i<n; i++){
            result[i] = drawMap(s1[i],s2[i]);
        }
        return result;
    }
    private String drawMap(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0; i<c1.length; i++){
            sb.append(c1[i]=='0'&&c2[i]=='0'?" ":"#");
        }
        return sb.toString();
    }
    private String decimalToBinaryString(int i, int length){
        StringBuilder sb = new StringBuilder();
        while(i>0){
            sb.insert(0,i%2);
            i /= 2;
        }
        while(sb.length()<length){
            sb.insert(0,0);
        }
        return sb.toString();
    }

}
