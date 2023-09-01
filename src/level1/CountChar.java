package level1;

public class CountChar {
    public static void main(String[] args) {

    }
    boolean solution(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if(c=='p'||c=='P'){
                count++;
            }else if(c=='y'||c=='Y'){
                count--;
            }
        }
        return count==0;
    }
}
