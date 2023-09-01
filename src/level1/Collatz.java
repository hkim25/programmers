package level1;

public class Collatz {
    private int count;
    public static void main(String[] args) {
        System.out.println(new Collatz().solution(626331));
    }
    public int solution(int num) {
        this.count = 0;
        process(num);
        return this.count>=500?-1:this.count;
    }
    private void process(long i){
        if(this.count>=500)return;
        if(i==1)return;
        this.count++;
        if(i%2==0){
            process(i/2);
        }else{
            process(i*3+1);
        }
    }
}
