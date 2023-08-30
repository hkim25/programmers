package level1;

public class FoodFight {
    public static void main(String[] args) {
        int[] food = {1, 7, 1, 2};
        System.out.println(new FoodFight().solution(food));
    }
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1; i<food.length; i++){
            if(food[i]>1){
                for(int j=0; j<food[i]/2; j++){
                    sb.insert(sb.indexOf("0"),i);
                    try{
                        sb.insert(sb.indexOf("0")+1,i);
                    }catch(StringIndexOutOfBoundsException e){
                        sb.insert(sb.length(),i);
                    }
                }
            }
        }
        return sb.toString();
    }
}
