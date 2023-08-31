package level1;

public class NumberGame {
    public static void main(String[] args) {
        String s = "2three45sixseven";
        System.out.println(new NumberGame().solution(s));
    }
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for(int i=0; i<array.length; i++){
            if(array[i]>='a'){
                switch(array[i]){
                    case 'z': sb.append("0");i+=3;break;
                    case 'o': sb.append("1");i+=2;break;
                    case 't':
                        if(array[i+1]=='w'){
                            sb.append("2");i+=2;
                        }else{
                            sb.append("3");i+=4;
                        }
                        break;
                    case 'f':
                        if(array[i+1]=='o'){
                            sb.append("4");
                        }else{
                            sb.append("5");
                        }
                        i+=3;
                        break;
                    case 's':
                        if(array[i+1]=='i'){
                            sb.append("6");i+=2;
                        }else{
                            sb.append("7");i+=4;
                        }
                        break;
                    case 'e': sb.append("8");i+=4;break;
                    case 'n': sb.append("9");i+=3;break;
                    default: throw new RuntimeException();
                }
            }else{
                sb.append(array[i]);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
