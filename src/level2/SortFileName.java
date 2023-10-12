package level2;

import java.util.Arrays;

public class SortFileName {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(new SortFileName().solution(files)));
    }
    public String[] solution(String[] files) {
        return Arrays.stream(files).map(FileName::new).sorted((o1, o2) -> {
            int result = o1.getHead().compareTo(o2.getHead());
            return result!=0?result:o1.getNumber()-o2.getNumber();
        }).map(FileName::getOrigin).toArray(String[]::new);
    }
}
class FileName{
    private final String origin;
    private final String head;
    private final int number;

    public FileName(String origin){
        StringBuilder sb = new StringBuilder();
        this.origin = origin;
        char[] arr = origin.toLowerCase().toCharArray();
        int idx = 0;
        while(idx<arr.length&&(arr[idx]<48||arr[idx]>57)){
            sb.append(arr[idx]);
            idx++;
        }
        this.head = sb.toString();
        sb.setLength(0);
        while(idx<arr.length&&(arr[idx]>=48&&arr[idx]<=57)){
            sb.append(arr[idx]);
            idx++;
        }
        this.number = Integer.parseInt(sb.toString());
        sb.setLength(0);
    }
    public String getOrigin() {
        return origin;
    }
    public String getHead() {
        return head;
    }
    public int getNumber() {
        return number;
    }
}
