import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {

	    System.out.println(solution1(new String[] {"mislav", "stanko", "mislav", "ana" },
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
        
        HashMap<String,Integer> map = HashMap<>();
        for(String part : participant){
            map.put(part, map.getOrDefault(part,0)+1);
        }

        for(String com : completion){
            
        }

        return answer;
    }
    
}