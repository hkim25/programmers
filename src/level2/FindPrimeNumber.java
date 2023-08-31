package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindPrimeNumber {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new FindPrimeNumber().solution(numbers));
    }
    public int solution(String numbers) {
        int count = 0;
        char[] arr = numbers.toCharArray();
        Set<Integer> cases = new HashSet<>();
        Set<Integer> primeSet = getPrimeSet(biggestNumber(arr));
        for(int i=1; i<=numbers.length(); i++){
            permutation(cases,arr,0,numbers.length(),i);
        }
        for(Integer i : cases){
            if(primeSet.contains(i))count++;
        }
        return count;
    }
    private void permutation(Set<Integer> set, char[] arr, int depth, int n, int r){
        if(depth==r){
            set.add(Integer.parseInt(new String(Arrays.copyOfRange(arr,0,r))));
            return;
        }
        for(int i=depth; i<n; i++){
            swap(arr,depth,i);
            permutation(set,arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }
    private void swap(char[] arr, int depth, int i){
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    public Set<Integer> getPrimeSet(int n) {
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
    private int biggestNumber(char[] arr){
        StringBuilder sb = new StringBuilder();
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(arr[i]));
        }
        intArr = IntStream.of(intArr).sorted().toArray();
        for(int i=intArr.length-1; i>=0; i--){
            sb.append(intArr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
