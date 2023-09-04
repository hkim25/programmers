package level2;

import java.util.Arrays;
import java.util.Set;

public class NextBinary {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        System.out.println(new NextBinary().solution(78));
    }
    public int solution(int n) {
        int one = countOne(decimalToBinaryString(n));
        for(int i=n+1; true; i++){
            if(countOne(decimalToBinaryString(i))==one)return i;
        }
    }
    private String decimalToBinaryString(int i){
        this.sb.setLength(0);
        while(i>0){
            this.sb.insert(0,i%2);
            i /= 2;
        }
        return this.sb.toString();
    }
    private int countOne(String s){
        int result = 0;
        for(char c : s.toCharArray()){
            if(c=='1')result++;
        }
        return result;
    }

    private void permutation(Set<Integer> set, char[] arr, int depth, int n, int r){
        if(depth==r){
            set.add(Integer.parseInt(new String(Arrays.copyOfRange(arr,0,r))));
            return;
        }
        for(int i=depth; i<n; i++){
            swap(arr,depth,i);
            permutation(set,arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }

    private void swap(char[] arr, int depth, int i){
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
