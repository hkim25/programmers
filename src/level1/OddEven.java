package level1;

public class OddEven {
    public static void main(String[] args) {
        System.out.println(new OddEven().solution(0));
    }
    public String solution(int num) {
        return num%2!=0?"Odd":"Even";
    }
}
