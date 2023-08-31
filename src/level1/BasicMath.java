package level1;

import java.util.Arrays;

public class BasicMath {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BasicMath().solution(80, 120)));
    }
    public int[] solution(int n, int m) {
        int x = euclid(n,m);
        return new int[]{x,n*m/x};
    }
    public int euclid(int a, int b){
        if(b==0)return a;
        return euclid(b,a%b);
    }
}
