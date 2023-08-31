package level1;

import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(a>0){
            sb.append("*");
            a--;
        }
        while(b>0){
            System.out.println(sb);
            b--;
        }
    }
}
