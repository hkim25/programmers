package level1;

public class MiddleChar {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new MiddleChar().solution(s));
    }
    public String solution(String s) {
        int m = s.length()/2+1;
        int n = s.length()%2!=0?m-1:m-2;
        return s.substring(n,m);
    }
}
