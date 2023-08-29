package level1;

public class Intonation {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        System.out.println(new Intonation().solution(babbling));
    }
    public int solution(String[] babbling) {
        int count = 0;
        for (String s : babbling) {
            if(validation(s))count++;
        }
        return count;
    }

    public boolean validation(String s){
        char[] array = s.toCharArray();
        boolean aya = false;
        boolean ye = false;
        boolean woo = false;
        boolean ma = false;
        try{
            for(int i=0; i<array.length;){
                switch(array[i]){
                    case 'a':
                        if(!aya){
                            i++;
                            if(array[i]=='y'){
                                i++;
                                if(array[i]=='a'){
                                    aya = true; ye=false; woo=false; ma=false;
                                    i++;
                                    continue;
                                }
                            }
                        }
                        return false;
                    case 'y':
                        if(!ye){
                            i++;
                            if(array[i]=='e'){
                                aya = false; ye=true; woo=false; ma=false;
                                i++;
                                continue;
                            }
                        }
                        return false;
                    case 'w':
                        if(!woo){
                            i++;
                            if(array[i]=='o'){
                                i++;
                                if(array[i]=='o'){
                                    aya = false; ye=false; woo=true; ma=false;
                                    i++;
                                    continue;
                                }
                            }

                        }
                        return false;
                    case 'm':
                        if(!ma){
                            i++;
                            if(array[i]=='a'){
                                aya = false; ye=false; woo=false; ma=true;
                                i++;
                                continue;
                            }
                        }
                        return false;
                    default : return false;
                }
            }
        }catch(ArrayIndexOutOfBoundsException ignored){
            return false;
        }
        return true;
    }
}
