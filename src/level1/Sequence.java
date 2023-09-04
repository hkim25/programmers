package level1;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Sequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sequence().solution(-4, 5)));
    }
    public long[] solution(int x, int n) {
        return LongStream.iterate(x,i->i+x).limit(n).toArray();
    }
}
