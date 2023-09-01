package level1;

import java.util.Arrays;

public class DivideSelf {
    public static void main(String[] args) {
        System.out.println(new DivideSelf().solution(11));
    }
    public boolean solution(int x) {
        return x%Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum()==0;
    }
}
