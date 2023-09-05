package level2;

public class MovingMan {
    public static void main(String[] args) {
        System.out.println(new MovingMan().solution(5));
    }
    public int solution(int n) {
        int count = 1;
        while(n>1){
            if(n%2!=0){
                n -=1;
                count++;
            }else{
                n /=2;
            }
        }
        return count;
    }
}
