package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakePrimeNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new MakePrimeNumber().solution(nums));
    }
    public int solution(int[] nums) {
        int result = 0;
        List<Object> list = Arrays.asList(Arrays.stream(nums).boxed().sorted().toArray());
        int size = list.size();
        Set<Integer> primeSet = findPrimeNumber((int) list.get(size-1) + (int) list.get(size-2) + (int) list.get(size-3));
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                for(int k=j+1; k<size; k++){
                    if(primeSet.contains((int)list.get(i)+(int)list.get(j)+(int)list.get(k))){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public Set<Integer> findPrimeNumber(int n) {
        Set<Integer> set = new HashSet<>();
        for(int i=2; i<=n; i++){
            set.add(i);
        }
        for(int i=2; i<=n; i++){
            if(set.contains(i)){
                int x=2;
                for(int j=i*x; j<=n; j=i*x){
                    set.remove(j);
                    x++;
                }
            }
        }
        return set;
    }
    private boolean[] findPrimeNumber2(int n) {
        boolean[] arr = new boolean[n+1];
        for(int i=2; i<Math.sqrt(n)+1; i++){
            if(!arr[i]){
                int x=2;
                for(int j=i*x; j<=n; j=i*x){
                    arr[j]=true;
                    x++;
                }
            }
        }
        return arr;
    }
}
