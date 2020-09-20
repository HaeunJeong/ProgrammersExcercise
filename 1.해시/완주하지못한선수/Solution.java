import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;


public class Solution {

	public static void main(String[] args) {

	    System.out.println(solution1(new String[] {"mislav", "stanko","mislav", "ana" },
				new String[] { "stanko", "ana", "mislav" }));
    }

    //정렬을 이용한 풀이
    public static String solution1(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = "";

        int i=0;
        while(i<participant.length){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
            i++;
        }
        return answer;
    }

    //HashMap을 이용한 풀이
    public static String solution2(String[] participant, String[] completion){
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String part : participant){
            map.put(part, map.getOrDefault(part,0)+1);
        }

        for(String com : completion){
            map.put(com, map.get(com)-1);
        }

        Set<Map.Entry<String, Integer>> enSet = new HashSet<>();
        enSet = map.entrySet();
        for(Map.Entry<String,Integer> e: enSet){
            if(e.getValue() > 0){
                answer = e.getKey();
                break;
            }
        }

        return answer;
    }
    
}