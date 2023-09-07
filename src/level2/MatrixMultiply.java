package level2;

import java.util.Arrays;
//TODO
public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(new MatrixMultiply().solution(arr1,arr2)));
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1[0].length];
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                System.out.printf("result[%d][%d]%n",i,j);
            }
        }
        return null;
    }
}
