package level1;

public class Split {
    public static void main(String[] args) {
        String t = "1";
        String p = "1";
        System.out.println(solution(t,p));
    }

    static int solution(String t, String p) {
        int result = 0;
        for(int i=0; i<t.length(); i++){
            try{
                if(!(Long.parseLong(t.substring(i,i+p.length())) > Long.parseLong(p)))result++;
            }catch(IndexOutOfBoundsException ignored){
                break;
            }
        }
        return result;
    }
}
