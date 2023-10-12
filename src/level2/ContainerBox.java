package level2;

import java.util.*;


public class ContainerBox {
    public static void main(String[] args) {
        int[] order = {3,5,4,2,1};
        System.out.println(new ContainerBox().solution2(order));
    }
    public int solution1(int[] order) {
        int answer = 0;
        int item = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<order.length;){
            if(item<=order.length&&order[i]==item){
                item++;
                answer++;
                i++;
            }else if(!stack.isEmpty()&&order[i]==stack.peek()){
                stack.pop();
                answer++;
                i++;
            }else{
                if(stack.contains(order[i]))break;
                stack.push(item);
                item++;
            }
        }
        return answer;
    }

    public int solution2(int[] order) {
        int answer = 0;
        int item = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<order.length&&item<=order.length;){
            while(item!=order[i]){
                stack.push(item);
                item++;
            }
            answer++;
            item++;
            i++;
            while(!stack.isEmpty()&&i<order.length&&stack.peek()==order[i]){
                stack.pop();
                answer++;
                i++;
            }
            try{
                if(stack.contains(order[i]))break;
            }catch(IndexOutOfBoundsException ignored){}
        }
        return answer;
    }
}
