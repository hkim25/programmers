package level1;

public class SumInt2 {
    public static void main(String[] args) {
        System.out.println(new SumInt2().solution(123));
    }
    public int solution(int n) {
        int i = 0;
        for(char c : String.valueOf(n).toCharArray()){
            i+=c-48;
        }
        return i;
    }
}
