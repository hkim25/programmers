package level1;

import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        String test = "..Aaaaaaaaaaaaaaaaaaaaaaaaa_...!@....$..A.a-A..$$%$.";
        System.out.println(new RegEx().solution(test));

    }
    public String solution(String new_id) {
        String reg2 = "[^a-z0-9-_.]";
        String reg3 = "\\.{2,}";
        String reg4 = "^\\.|\\.$";

        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll(reg2,"");
        new_id = new_id.replaceAll(reg3,".");
        new_id = new_id.replaceAll(reg4, "");
        if(new_id.length()>15){
            new_id = new_id.substring(0,15);
            if(new_id.endsWith("."))new_id = new_id.substring(0,14);
        }
        if(new_id.length()<3){
            switch(new_id.length()){
                case 0: new_id = "aaa";
                    break;
                case 1:
                    new_id = new_id + new_id.charAt(0) + new_id.charAt(0);
                    break;
                case 2:
                    new_id = new_id + new_id.charAt(1);
                    break;
            }
        }
        return new_id;
    }
}
