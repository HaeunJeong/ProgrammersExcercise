import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3, 3, 1})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Arrays.fill(answer,0);
        /*
        for (int an : answer){
            an=0;
        }
        */

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                answer[i]+=1;
                if(prices[i] > prices[j])
                {
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer,0);

        Stack<Integer> stack = new Stack<>();

        stack.put(prices[0]);
        for(int i=1; i<prices.length; i++){
            if(prices[i] < stack.peek()){
                while(stack.size())
                stack.pop();
            }
            else{
                stack.put(prices[i]);
            }
        }


        return answer;
    }
}