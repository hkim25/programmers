package level1;

public class TriNumber {
    public static void main(String[] args) {
        System.out.println(new TriNumber().solution(45));
    }
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int e = 0;
        int result = 0;
        while(n>0){
            sb.append(n%3);
            n/=3;
        }
        char[] arr = sb.toString().toCharArray();
        for(int i=arr.length-1; i>=0; i--){
            result += (arr[i]-48)*Math.pow(3,e);
            e++;
        }
        return result;
    }
}
