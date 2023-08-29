package level1;

import java.util.Arrays;

public class Wallpaper {
    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }
    static int[] solution(String[] wallpaper) {
        boolean isLuyRecorded = false;
        int minHeight = 0;
        int maxHeight = 0;
        int minWidth = wallpaper[0].length();
        int maxWidth = 0;
        for(int i=0; i<wallpaper.length; i++){
            if(wallpaper[i].contains("#")){
                maxHeight = i;
                if(!isLuyRecorded){
                    minHeight = i;
                    isLuyRecorded = true;
                }
                minWidth=Math.min(wallpaper[i].indexOf("#"), minWidth);
                maxWidth=Math.max(wallpaper[i].lastIndexOf("#"), maxWidth);
            }
        }
        return new int[]{minHeight,minWidth,maxHeight+1,maxWidth+1};
    }
}
