package level1;

public class SumNotExist {
    public static void main(String[] args) {

    }
    public int solution(int[] numbers) {
        int result = 50;
        for(int i : numbers){
            result -= i;
        }
        return result;
    }
}
