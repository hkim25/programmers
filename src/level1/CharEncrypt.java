package level1;

public class CharEncrypt {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(new CharEncrypt().solution(s,n));
    }
    public String solution(String s, int n) {
        char[] array = s.toCharArray();
        char[] result = new char[array.length];
        for(int i=0; i<array.length; i++){
            result[i] = push(array[i],n);
        }
        return new String(result);
    }
    private char push(char c, int i){
        if(c>='a'){
            return c+i>'z'?(char)('a'+((c+i-'z'-1)%26)):(char)(c+i);
        }else if(c>='A'){
            return c+i>'Z'?(char)('A'+((c+i-'Z'-1)%26)):(char)(c+i);
        }else{
            return c;
        }
    }
}
