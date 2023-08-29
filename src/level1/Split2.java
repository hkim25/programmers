package level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class Split2 {
    public static void main(String[] args) {
        System.out.println(solution("aaabbaccccabba"));
    }
    static int solution(String s) {
        boolean loop = true;
        int resultCount = 0;
        String data = s;
        while(loop){
            loop = false;
            int headCount = 0;
            int otherCount = 0;
            char head = data.charAt(0);
            for(int i=0; i<data.length(); i++){
                if(data.charAt(i)==head){
                    headCount++;
                }else{
                    otherCount++;
                }
                if(headCount==otherCount){
                    data = data.substring(i+1);
                    loop = !data.isEmpty();
                    resultCount++;
                    break;
                }
            }
        }
        if(!data.isEmpty())resultCount++;
        return resultCount;
    }
}
