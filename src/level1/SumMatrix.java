package level1;

public class SumMatrix {
    public static void main(String[] args) {

    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++){
                arr2[i][j] += arr1[i][j];
            }
        }
        return arr2;
    }
}
