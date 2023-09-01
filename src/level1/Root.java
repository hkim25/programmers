package level1;

public class Root {
    public static void main(String[] args) {
        System.out.println(new Root().solution(121));
    }
    public long solution(long n) {
        double root = Math.sqrt(n);
        return root%1==0? ((long)(root + 1) * (long)(root + 1)) :-1;
    }
}
