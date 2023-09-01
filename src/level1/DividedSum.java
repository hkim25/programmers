package level1;

public class DividedSum {
    public static void main(String[] args) {
        System.out.println(new DividedSum().solution(15));
    }
    public int solution(int n) {
        int result = n;
        for(int i=1; i<=n/2; i++){
            if(n%i==0)result+=i;
        }
        return result;
    }
}
