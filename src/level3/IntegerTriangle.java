package level3;
//TODO
public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new IntegerTriangle().solution(triangle));
    }
    public int solution(int[][] triangle) {
        int result = 0;
        int idx = 0;
        result += triangle[0][idx];
        for(int i=1; i<triangle.length-1; i++){
            boolean left = triangle[i][idx]>triangle[i][idx+1];
        }
        return 0;
    }

}
