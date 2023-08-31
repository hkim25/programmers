package level1;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 9999999;
        System.out.println(new PrimeNumber().solution(n));

    }
    public int solution(int n) {
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
        return set.size();
    }
}
