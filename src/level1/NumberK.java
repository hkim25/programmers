package level1;

import java.util.Arrays;

public class NumberK {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(new NumberK().solution(array, commands)));
    }
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands).map(c->Arrays.stream(Arrays.stream(array,c[0]-1,c[1]).sorted().toArray(),c[2]-1,c[2])).flatMapToInt(e->e).toArray();
    }
}
