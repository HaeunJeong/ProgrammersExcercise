import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int k: scoville){
            queue.add(k);
        }

        while(!queue.isEmpty()){
            int pop = queue.poll().intValue();
            if(pop<K && !queue.isEmpty()){
                queue.add(pop+queue.poll().intValue()*2);
                answer++;
            }
            else if(pop<K){
                answer=-1;
                break;
            }
            else{
                break;
            }
        }

        return answer;
    }
}