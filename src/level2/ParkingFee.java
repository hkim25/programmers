package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees = {180,5000,10,600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(new ParkingFee().solution(fees, records)));
    }
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new HashMap<>();
        FeeCalculator cal = new FeeCalculator(fees);
        for(String s : records){
            String carNum = s.split(" ")[1];
            if(!map.containsKey(carNum)){
                map.put(carNum, new Car());
            }
            map.get(carNum).addRecord(s);
        }
        int[] result = new int[map.size()];
        List<String> sorted = map.keySet().stream().sorted().collect(Collectors.toList());
        for(int i=0; i<sorted.size(); i++){
            Stack<Integer> stack = map.get(sorted.get(i)).getRecords();
            int accumulates = 0;
            if(stack.size()%2!=0){
                map.get(sorted.get(i)).addRecord("23:59");
            }
            while(!stack.isEmpty()){
                accumulates += stack.pop() - stack.pop();
            }
            result[i] = cal.calculate(accumulates);
        }
        return result;
    }
}

class FeeCalculator{
    final int basicMin;
    final int basicFee;
    final int unitMin;
    final int unitFee;

    FeeCalculator(int[] fees) {
        basicMin = fees[0];
        basicFee = fees[1];
        unitMin = fees[2];
        unitFee = fees[3];
    }
    public int calculate(int accumulates){
        int result = basicFee;
        if(accumulates>basicMin){
            accumulates -= basicMin;
            result += accumulates/unitMin*unitFee;
            if(accumulates%unitMin!=0)result+=unitFee;
        }
        return result;
    }
}
class Car{
    private final Stack<Integer> records;

    Car() {
        records = new Stack<>();
    }
    public Stack<Integer> getRecords() {
        return records;
    }
    public void addRecord(String record){
        String[] arr = record.split(" ");
        String[] time = arr[0].split(":");
        this.records.add(Integer.parseInt(time[0])*60+Integer.parseInt(time[1]));
    }
}

