package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println(Arrays.toString(new Compression().solution(msg)));
    }
    public int[] solution(String msg) {
        Compressor compressor = new Compressor(msg, new LargeCaseDictionary());
        return compressor.compress().getCompressed();
    }
}

class Compressor{
    private final Dictionary dictionary;
    private final StringBuilder remain;
    private final StringBuilder worker;
    private final List<Integer> result;
    private boolean isCompressed = false;
    public Compressor(String s, Dictionary dictionary){
        this.result = new ArrayList<>();
        this.dictionary = dictionary;
        this.remain = new StringBuilder(s);
        this.worker = new StringBuilder();
    }
    public Compressor compress(){
        while(this.remain.length()!=0){
            int idx = 0;
            this.worker.setLength(0);
            this.worker.append(this.remain.charAt(idx));
            while(this.dictionary.contains(this.worker.toString())){
                idx++;
                try{
                    this.worker.append(this.remain.charAt(idx));
                }catch (StringIndexOutOfBoundsException e){
                    this.result.add(this.dictionary.get(this.worker.toString()));
                    this.remain.setLength(0);
                    this.isCompressed = true;
                    return this;
                }
            }
            this.dictionary.put(this.worker.toString(),this.dictionary.getLastIdx()+1);
            this.result.add(this.dictionary.get(this.worker.substring(0,this.worker.length()-1)));
            this.remain.delete(0,idx);
        }
        this.isCompressed = true;
    return this;
    }
    public int[] getCompressed(){
        if(this.isCompressed){
            int[] arr = new int[this.result.size()];
            for(int i=0; i<this.result.size(); i++){
                arr[i] = this.result.get(i);
            }
            return arr;
        }else{
            throw new RuntimeException();
        }
    }
}

interface Dictionary{
    boolean contains(String s);
    int getLastIdx();
    void put(String s, Integer i);
    Integer get(String key);
}

class LargeCaseDictionary implements Dictionary{
    private final Map<String,Integer> dictionary;

    LargeCaseDictionary() {
        this.dictionary = new HashMap<>();
        for(int i = 1; i<27; i++){
            this.dictionary.put(String.valueOf((char)('@'+i)),i);
        }
    }
    @Override
    public String toString() {
        return this.dictionary.toString();
    }
    @Override
    public boolean contains(String s){
        return this.dictionary.containsKey(s);
    }
    @Override
    public int getLastIdx(){
        return this.dictionary.size();
    }
    @Override
    public void put(String s, Integer i) {
        this.dictionary.put(s,i);
    }
    @Override
    public Integer get(String key) {
        return this.dictionary.get(key);
    }
}
