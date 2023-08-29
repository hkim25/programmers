package level1;
import java.util.regex.Pattern;

public class Dart {
    public static void main(String[] args) {
        String dartResult = "1S*2T*3S";
        System.out.println(new Dart().solution(dartResult));
    }
    public int solution(String dartResult) {
        int result = 0;
        String[] parsed;
        parsed = parseGame(dartResult).split(" ");
        for(int i: calculate(parsed)){
            result += i;
        }
        return result;
    }
    private String parseGame(String data){
        boolean isPrevInt = true;
        boolean isInt;
        char[] array = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : array){
            String s = String.valueOf(c);
            isInt = Pattern.matches("\\d",s);
            if(!isPrevInt&&isInt){
                sb.append(" ");
            }
            sb.append(s);
            isPrevInt = isInt;
        }
        return sb.toString();
    }

    private int[] calculate(String[] parsed){
        int[] score = new int[3];
        String[] bonus = new String[3];
        String[] option = new String[3];

        for(int i=0; i<parsed.length; i++){
            score[i] = Integer.parseInt(parsed[i].replaceAll("\\D",""));
            bonus[i] = parsed[i].replaceAll("[^A-Z]","");
            option[i] = parsed[i].replaceAll("[^*#]","");
        }
        for(int i=0; i<score.length; i++){
            switch (bonus[i]){
                case "D":
                    score[i] = (int) Math.pow(score[i],2);
                    break;
                case "T":
                    score[i] = (int) Math.pow(score[i],3);
                    break;
                default:break;
            }
            switch (option[i]){
                case "*":
                    try{
                        score[i-1] *= 2;
                    }catch(ArrayIndexOutOfBoundsException ignored){}
                    score[i] *= 2;
                    break;
                case "#":
                    score[i] *= -1;
                    break;
                default:break;
            }
        }
        return score;
    }
}
