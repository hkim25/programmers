package level2;

public class Tournament {
    public static void main(String[] args) {
        System.out.println(new Tournament().solution(8,2,3));
    }
    public int solution(int n, int a, int b) {
        int result = 1;
        while(true){
            if(a-b==-1||a-b==1){
                if(Math.min(a,b)%2!=0)break;
            }
            a = nextNumber(a);
            b = nextNumber(b);
            result++;
        }
        return result;
    }
    static private int nextNumber(int n){
        return n%2!=0?n/2+1:n/2;
    }
}
