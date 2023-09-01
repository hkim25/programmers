package level1;

public class ReplaceAster {
    public static void main(String[] args) {
        String s = "027778888";
        System.out.println(new ReplaceAster().solution(s));
    }
    public String solution(String phone_number) {
        char[] arr = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++){
            arr[i] = '*';
        }
        return new String(arr);
    }
}
