package level2;

import java.util.Stack;

public class PairDelete {
    public static void main(String[] args) {
        System.out.println(new PairDelete().solution("bcaacb"));
    }
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        if(s!=null&&!s.isEmpty()){
            char[] arr = s.toCharArray();
            stack.push(arr[0]);
            for(int i=1; i<arr.length; i++){
                if(!stack.isEmpty()&&stack.peek()==arr[i]){
                    stack.pop();
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        return stack.isEmpty()?1:0;
    }
}
