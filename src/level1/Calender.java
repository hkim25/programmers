package level1;

public class Calender {
    public static void main(String[] args) {
        System.out.println(new Calender().solution(2,5));
    }
    public String solution(int a, int b) {
        final String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int date = 0;
        for(int i=1; i<a; i++){
            date += selectMonth(i);
        }
        date += b;
        return day[date%7];
    }
    private int selectMonth(int m){
        switch(m){
            case 2: return 29;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            default : return 30;
        }
    }
}
