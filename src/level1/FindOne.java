package level1;

public class FindOne {
    public static void main(String[] args) {
        System.out.println(new FindOne().solution(3));
    }
    public int solution(int n) {
        int x = 1;
        while(n%x!=1){
            x++;
        }
        return x;
    }
}
