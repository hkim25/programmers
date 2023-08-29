package level1;

import java.util.Arrays;

public class MathHater {
    private final int[] student1 = {1,2,3,4,5};
    private final int[] student2 = {2,1,2,3,2,4,2,5};
    private final int[] student3 = {3,3,1,1,2,2,4,4,5,5};
    private final int idx1 = this.student1.length;
    private final int idx2 = this.student2.length;
    private final int idx3 = this.student3.length;
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(new MathHater().solution(answers)));
    }
    public int[] solution(int[] answers) {
        int[] answer = null;
        int score1 = 0; int score2 = 0; int score3 = 0;
        for(int i=0; i<answers.length; i++){
            if(answers[i]==this.student1[i%idx1])score1++;
            if(answers[i]==this.student2[i%idx2])score2++;
            if(answers[i]==this.student3[i%idx3])score3++;
        }
        if(score1>score2){
            if(score1>score3){
                answer = new int[]{1};
            }else if(score1<score3){
                answer = new int[]{3};
            }else{
                answer = new int[]{1,3};
            }
        }else if(score1<score2){
            if(score2>score3){
                answer = new int[]{2};
            }else if(score2<score3){
                answer = new int[]{3};
            }else{
                answer = new int[]{2,3};
            }
        }else{
            if(score2>score3){
                answer = new int[]{1,2};
            }else if(score2==score3){
                answer = new int[]{1,2,3};
            }
        }
        return answer;
    }
}
