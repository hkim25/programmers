package level2;

import java.util.Arrays;

public class FriendsBlock {
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(new FriendsBlock().solution(4,5,board));
    }
    public int solution(int m, int n, String[] board) {
        int result = 0;
        char[][] cArr = process(m,n,Arrays.stream(board).map(String::toCharArray).toArray(char[][]::new));
        for(char[] arr : cArr){
            for(char c : arr){
                if(c==0)result++;
            }
        }
        return result;
    }

    private char[][] process(int m, int n, char[][] cArr){
        boolean[][] bArr = new boolean[m][n];
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                if(cArr[i][j]==0){
                    continue;
                }
                char c = cArr[i][j];
                boolean b = cArr[i+1][j]==c&&cArr[i][j+1]==c&&cArr[i+1][j+1]==c;
                if(b){
                    for(int y=i; y<=i+1; y++){
                        for(int x=j; x<=j+1; x++){
                            bArr[y][x] = true;
                        }
                    }
                }
            }
        }
        boolean isChanged = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(bArr[i][j]){
                    cArr[i][j]=0;
                    isChanged = true;
                }
            }
        }
        if(!isChanged)return cArr;
        for(int j=0; j<n; j++){
            boolean isSorted = false;
            for(int i=m-1; i>0; i--){
                if(isSorted)break;
                if(cArr[i][j]==0){
                    for(int x=i; x>=0; x--){
                        isSorted=true;
                        if(cArr[x][j]!=0){
                            isSorted=false;
                            char temp = cArr[i][j];
                            cArr[i][j] = cArr[x][j];
                            cArr[x][j] = temp;
                            break;
                        }
                    }
                }
            }
        }
        return process(m,n,cArr);
    }
}
