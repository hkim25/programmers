package level2;

import java.util.Arrays;

public class MultiCommon {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(new MultiCommon().solution(arr));
    }
    public int solution(int[] arr) {
        boolean flag = true;
        arr = Arrays.stream(arr).sorted().toArray();
        int result = arr[arr.length-1];
        int i = 1;
        while(flag){
            flag=false;
            for(int idx=arr.length-1; idx>=0; idx--){
                if(result%arr[idx]!=0){
                    flag=true;
                    i++;
                    result = arr[arr.length-1]*i;
                    break;
                }
            }
        }
        return result;
    }
}
