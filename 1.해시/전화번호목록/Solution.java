import java.util.Arrays;
import java.util.HashMap;


public class Solution {

	public static void main(String[] args) {

	    System.out.println(solution(new String[]{"119", "1192020242432", "9767422"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        //phone_book 길이별로 정렬 후  큰것 부터 넣고, 넣을때부터 접두어 있는지 검사.
        Arrays.sort(phone_book, (a,b)->Integer.compare(b.length(), a.length())
        );
        

        HashMap<String, Integer> map = new HashMap<>();
        for(String phone_number : phone_book){
            String number = phone_number.replaceAll(" ","");
            for(String key : map.keySet()){  
                if(key.startsWith(number)){
                    answer = false;
                    return answer;
                }    
            }
            map.put(number, number.length());
        }
        /*
        for(String key : map.keySet()){
            for(String toKey : map.keySet()){
                if(!toKey.equals(key) && toKey.startsWith(key)){
                    answer = false;
                    break;
                }
            }
        }
        */
        return answer;
    }


    
}