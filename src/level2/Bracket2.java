package level2;

import java.util.Stack;

public class Bracket2 {
    public static void main(String[] args) {
        System.out.println(new Bracket2().solution("("));
    }
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> recent = new Stack<>();
        int count = 0;
        for(int i=0; i<sb.length(); i++){
            boolean validation = true;
            recent.clear();
            for(char c : sb.toString().toCharArray()){
                switch(c){
                    case'(': case'[': case'{':
                        recent.push(c); break;
                    case')':
                        if(recent.isEmpty()||recent.pop()!='(')validation=false;
                        break;
                    case']':
                        if(recent.isEmpty()||recent.pop()!='[')validation=false;
                        break;
                    case'}':
                        if(recent.isEmpty()||recent.pop()!='{')validation=false;
                        break;
                }
                if(!validation)break;
            }
            if(recent.isEmpty()&&validation)count++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return count;
    }
}
