package level2;

import java.util.HashMap;
import java.util.Map;

public class WishList {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new WishList().solution(want,number,discount));
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            indexMap.put(want[i], i);
        }
        for(int i=0; i<10; i++){
            if(indexMap.containsKey(discount[i])){
                number[indexMap.get(discount[i])]--;
            }
        }
        if(isOk(number))result++;
        for(int i=1; i<discount.length-want.length; i++){
            try{
                if(indexMap.containsKey(discount[i+9])){
                    number[indexMap.get(discount[i+9])]--;
                }
            }catch(IndexOutOfBoundsException ignored){}
            if(indexMap.containsKey(discount[i-1])){
                number[indexMap.get(discount[i-1])]++;
            }
            if(isOk(number))result++;
        }
        return result;
    }
    private boolean isOk(int[] arr){
        for(int i : arr){
            if(i>0)return false;
        }
        return true;
    }
}
