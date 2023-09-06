public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");

        sb.replace(0,2,"k");
        System.out.println(sb);
    }
}
