package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatting {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new OpenChatting().solution(record)));
    }
    public String[] solution(String[] record) {
        final String ENTER = "%s님이 들어왔습니다.";
        final String LEAVE = "%s님이 나갔습니다.";
        List<String> list = new ArrayList<>();
        Map<String, String> uidMap = new HashMap<>();
        for(int i=record.length-1; i>=0; i--){
            String[] arr = record[i].split(" ");
            if(!uidMap.containsKey(arr[1])&&!arr[0].equals("Leave")){
                uidMap.put(arr[1],arr[2]);
            }
        }
        for(String s : record){
            if(!s.startsWith("Change")){
                String[] arr = s.split(" ");
                list.add(String.format(arr[0].equals("Enter")?ENTER:LEAVE,uidMap.get(arr[1])));
            }
        }
        String[] result = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
