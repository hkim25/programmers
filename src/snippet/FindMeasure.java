package snippet;

public class FindMeasure {
    public static void main(String[] args) {
        System.out.println(new FindMeasure().countMeasure(25));
    }
    int countMeasure(int n){
        int result = 0;
        double sqrt = Math.sqrt(n);
        for(int i=1; i<=sqrt; i++){
            if(n%i==0) result++;
        }
        result *= 2;
        if(sqrt%1==0) result--;
        return result;
    }
}
