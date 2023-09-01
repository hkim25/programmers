package level1;

public class SumAbs {
    public static void main(String[] args) {
        int[] absolutes = {};
        boolean[] signs = {};
    }
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for(int i=0; i<absolutes.length; i++){
            result += signs[i]?absolutes[i]:absolutes[i]*-1;
        }
        return result;
    }
}
