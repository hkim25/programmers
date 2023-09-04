package level2;

public class JadenCase {
    public static void main(String[] args) {
        System.out.println(new JadenCase().solution("3people unFollowed me"));
    }
    public String solution(String s) {
        boolean isHead = true;
        char[] arr = s.toLowerCase().toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==' '){isHead=true; continue;}
            if(isHead&&arr[i]>=97&&arr[i]<=122){
                arr[i] = (char)(arr[i] - 32);
            }
            isHead=false;
        }
        return new String(arr);
    }
}
