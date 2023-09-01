package level1;

public class SumInt {
    public static void main(String[] args) {
        System.out.println(new SumInt().solution(5,3));
    }
    public long solution(int a, int b) {
        return (long)(a + b)*(Math.abs(a-b)+1)/2;
    }
}
