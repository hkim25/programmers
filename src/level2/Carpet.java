package level2;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Carpet().solution(24, 24)));
    }
    public int[] solution(int brown, int yellow) {
        int a = -1;
        int b = (brown+4)/2;
        int c = -2*b+(4-yellow);
        double sqrt = Math.sqrt(b*b-(4*a*c));
        if(sqrt%1!=0)throw new RuntimeException();
        return new int[]{((-1*b)-(int)sqrt)/(a*2),((-1*b)+(int)sqrt)/(a*2)};
    }
}
