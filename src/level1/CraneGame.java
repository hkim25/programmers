package level1;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CraneGame {
    public static void main(String[] args) {
        int[][] board =  {{1, 0, 0, 0, 0}, {2, 0, 0, 0, 0}, {2, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {3, 0, 0, 0, 0}};
        int[] moves = {1, 1, 1, 1};
        System.out.println(new CraneGame().solution(board,moves));
    }
    public int solution(int[][] board, int[] moves) {
        Box box = new Box(board);
        for(int i : moves){
            box.gatcha(i);
        }
        return box.getCount();
    }
}

class Box{
    private final Map<Integer, Stack<Integer>> board;
    private final Stack<Integer> picked;
    private int count;

    Box(int[][] board) {
        if(board==null||board.length==0||board[0]==null||board[0].length==0){
            throw new RuntimeException("Invalid board data");
        }
        this.board = new HashMap<>();
        this.picked = new Stack<>();
        this.count = 0;
        for(int i=0; i<board[0].length; i++){
            this.board.put(i+1, new Stack<>());
        }
        for(int i=board.length-1;i>=0;i--){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]!=0){
                    this.board.get(j+1).push(board[i][j]);
                }
            }
        }
    }
    public void gatcha(int lineNum){
        try{
            int val = this.board.get(lineNum).pop();
            try{
                int lastPicked = this.picked.peek();
                if(val==lastPicked){
                    this.picked.pop();
                    this.count+=2;
                }else{
                    this.picked.push(val);
                }
            }catch(EmptyStackException e){
                this.picked.push(val);
            }
        }catch(EmptyStackException ignored){
        }
    }
    public int getCount() {
        return count;
    }
}
