package level1;

public class Watermelon {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Watermelon().solution(n));
    }
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(i%2!=0?"수":"박");
        }
        return sb.toString();
    }
}
