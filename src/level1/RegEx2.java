package level1;

import java.util.regex.Pattern;

public class RegEx2 {
    public static void main(String[] args) {
    }
    public boolean solution(String s) {
        return Pattern.matches("^\\d{4}$",s)||Pattern.matches("^\\d{6}$",s);
    }
}
