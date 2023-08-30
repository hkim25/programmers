package level1;

public class EmptyBottle {
    public static void main(String[] args) {
        System.out.println(new EmptyBottle().solution(3,1,20));
    }
    public int solution(int a, int b, int n) {
        int r = 0;
        while(n>=a){
            n-=a;
            r+=b;
            n+=b;
        }
        return r;
    }
}
