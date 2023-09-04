package level2;

public class Bracket {
    public static void main(String[] args) {

    }
    boolean solution(String s) {
        int i = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                i++;
            }else{
                i--;
            }
            if(i<0)break;
        }
        return i==0;
    }
}
