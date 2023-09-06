package level2;

public class HIndex {
    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5, 8, 10, 5, 4, 3};
        System.out.println(new HIndex().solution(arr));
    }
    public int solution(int[] citations) {
        int h = citations.length;
        boolean flag = true;
        while(flag){
            flag = false;
            int count = citations.length;
            for(int i : citations){
                if(i<h)count--;
                if(count<h){flag = true; h--; break;}
            }
        }
        return h;
    }
}
