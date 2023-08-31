package level1;

public class Wallet {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(new Wallet().solution(sizes));
    }
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for(int[] arr : sizes){
            boolean b = arr[0]>arr[1];
            if(b){
                if(arr[0]>x)x=arr[0];
                if(arr[1]>y)y=arr[1];
            }else{
                if(arr[1]>x)x=arr[1];
                if(arr[0]>y)y=arr[0];
            }
        }
        return x*y;
    }
}
