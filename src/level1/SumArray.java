package level1;

public class SumArray {
    public static void main(String[] args) {

    }
    public int solution(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}
