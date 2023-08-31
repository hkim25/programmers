package level1;

public class StrangeString {
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(new StrangeString().solution(s));
    }
    public String solution(String s) {
        boolean flag = true;
        char[] array = s.toLowerCase().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i]==32){
                flag = true;
            }else{
                if(flag){
                    array[i] = (char) (array[i]-32);
                    flag = false;
                }else{
                    flag = true;
                }
            }
        }
        return new String(array);
    }
}
