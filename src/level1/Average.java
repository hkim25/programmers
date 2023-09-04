package level1;

public class Average {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new Average().solution(arr));
    }
    public double solution(int[] arr) {
        double sum = 0;
        for(int i : arr){
            sum+= i;
        }
        return sum/(double)arr.length;
    }
}
