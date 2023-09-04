package level1;

public class ParseInt {
    public static void main(String[] args) {
        System.out.println(new ParseInt().solution("-9787"));
    }
    public int solution(String s) {
        int result = 0;
        boolean isMinus = false;
        try{
            if(s.charAt(0)=='-'||s.charAt(0)=='+'){
                isMinus = s.charAt(0)=='-';
                s = s.substring(1);
            }
            char[] arr = s.toCharArray();
            for(int i=0; i<arr.length; i++){
                if(arr[i]>57||arr[i]<48)throw new NumberFormatException();
                result += (arr[i]-48)*Math.pow(10,arr.length-i-1);
            }
        }catch(NullPointerException | StringIndexOutOfBoundsException ex){
            throw new NumberFormatException();
        }
        return isMinus?-1*result:result;
    }
}
