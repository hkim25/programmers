package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hamburger {
    private int result = 0;
    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(new Hamburger().solution(ingredient));
    }
    int solution(int[] ingredient) {
        List<Integer> list = Arrays.stream(ingredient).boxed().collect(Collectors.toList());
        find(list);
        return this.result;
    }
    void find(List<Integer> list){
        for (int i = 0; i<list.size(); i++) {
            if (this.flag1) {
                if (this.flag2) {
                    if(this.flag3){
                        if(list.get(i) == 1){
                            this.result++;
                            list.remove(i-3);
                            list.remove(i-3);
                            list.remove(i-3);
                            list.remove(i-3);
                            i = i>8?i-8:0;
                        }
                        this.flag1 = false;
                        this.flag2 = false;
                        this.flag3 = false;
                    }else{
                        if(list.get(i) == 3){
                            this.flag3 = true;
                        }else{
                            this.flag2 = false;
                            this.flag1 = list.get(i) == 1;
                        }
                    }
                } else {
                    if(list.get(i) == 2){
                        this.flag2 = true;
                    }else{
                        this.flag1 = list.get(i) == 1;
                    }
                }
            } else {
                this.flag1 = list.get(i) == 1;
            }
        }
    }
}
