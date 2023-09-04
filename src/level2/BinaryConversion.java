package level2;

import java.util.Arrays;

public class BinaryConversion {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BinaryConversion().solution("01110")));
    }
    public int[] solution(String s) {
        int[] result = new int[2];
        process(result, s);
        return result;
    }
    private void process(int[] arr, String s){
        if(s.equals("1"))return;
        arr[0]++;
        int one = 0;
        for(char c : s.toCharArray()){
            if(c!='0')one++;
        }
        arr[1]+=s.length()-one;
        process(arr,decimalToBinaryString(one));
    }
    private String decimalToBinaryString(int i){
        this.sb.setLength(0);
        while(i>0){
            this.sb.insert(0,i%2);
            i /= 2;
        }
        return this.sb.toString();
    }
}
