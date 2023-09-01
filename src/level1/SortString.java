package level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortString {
    public static void main(String[] args) {
        System.out.println(new SortString().solution("Zbcdefg"));
    }
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}
