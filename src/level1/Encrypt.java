package level1;

public class Encrypt {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s,skip,index));

    }
    static String solution(String s, String skip, int index) {
        StringBuilder key = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder value = new StringBuilder(s);
        for(int i=0; i<skip.length(); i++){
            key.deleteCharAt(key.indexOf(String.valueOf(skip.charAt(i))));
        }
        for(int i=0; i<value.length(); i++){
            int newIdx = key.indexOf(String.valueOf(value.charAt(i)))+index;
            while(newIdx>key.length()-1){
                newIdx-=key.length();
            }
            value.replace(i,i+1,String.valueOf(key.charAt(newIdx)));
        }
        return value.toString();
    }
}
