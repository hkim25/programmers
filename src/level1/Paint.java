package level1;

public class Paint {
    public static void main(String[] args) {
        System.out.println(solution(8,4, new int[]{1, 2, 3, 4}));
    }
    static int solution(int n, int m, int[] section) {
        int count = 0;
        int painted = 0;
        int end = section[section.length-1];
        for(int i : section){
            if(i<painted)continue;
            painted = i + m;
            count++;
            if(painted>end)break;
        }
        return count;
    }
}
