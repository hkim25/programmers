package level1;

import java.util.HashMap;
import java.util.Map;

public class PhoneKey {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(new PhoneKey().solution(numbers,hand));
    }
    public String solution(int[] numbers, String hand) {
        Person person = new Person(new Phone(), hand);
        for(int i : numbers){
            person.pushButton(i);
        }
        return person.getTrace();
    }
}

class Phone {
    private final Map<Integer,int[]> number;
    Phone() {
        this.number = new HashMap<>();
        this.number.put(-1, new int[]{0, 0});
        this.number.put(-2, new int[]{2, 0});
        this.number.put(1, new int[]{0, 3});
        this.number.put(2, new int[]{1, 3});
        this.number.put(3, new int[]{2, 3});
        this.number.put(4, new int[]{0, 2});
        this.number.put(5, new int[]{1, 2});
        this.number.put(6, new int[]{2, 2});
        this.number.put(7, new int[]{0, 1});
        this.number.put(8, new int[]{1, 1});
        this.number.put(9, new int[]{2, 1});
        this.number.put(0, new int[]{1, 0});
    }
    public Map<Integer, int[]> getNumber() {
        return number;
    }
}

class Person{
    private final Phone phone;
    private final boolean isRightHand;
    private final StringBuilder trace;
    private int[] left;
    private int[] right;

    Person(Phone phone, String hand) {
        this.phone = phone;
        this.isRightHand = hand.equals("right");
        this.trace = new StringBuilder();
        this.left = this.phone.getNumber().get(-1);
        this.right = this.phone.getNumber().get(-2);
    }
    public void pushButton(int i){
        switch(i){
            case 1:
            case 4:
            case 7:
                useLeft(i);
                break;
            case 0:
            case 2:
            case 5:
            case 8:
                int ld = this.getDistance(this.left,this.phone.getNumber().get(i));
                int rd = this.getDistance(this.right,this.phone.getNumber().get(i));
                if(ld>rd){
                    useRight(i);
                }else if(ld<rd){
                    useLeft(i);
                }else {
                    if(this.isRightHand){
                        useRight(i);
                    }else{
                        useLeft(i);
                    }
                }
                break;
            case 3:
            case 6:
            case 9:
                useRight(i);
                break;
        }
    }
    private int getDistance(int[] start, int[] end){
        return Math.abs(start[0]-end[0])+Math.abs(start[1]-end[1]);
    }
    private void useRight(int i){
        this.right = this.phone.getNumber().get(i);
        this.trace.append("R");
    }
    private void useLeft(int i){
        this.left = this.phone.getNumber().get(i);
        this.trace.append("L");
    }
    public String getTrace(){
        return this.trace.toString();
    }
}
