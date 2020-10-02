import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        //int[] answer = {}; //각 배포때, 몇개의 progresses가 배포되는지
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> whenFinished = new Stack<>();

        //progresses 를 뒤에서부터 보며(배포나중에해야하는거)
        //배포가능 몇일후인지, 계산해서 stack에 집어넣기
        //stack에서 뽑으면서 일자를 보고, 일자보다 같거나 낮은것들은 같이 뽑아서 배포.
        for(int i=progresses.length-1; i>=0; i--){
            whenFinished.push((int)Math.ceil((float)(100 - progresses[i])/(float)speeds[i]));
        }

        int i=1;
        try{

            int std=whenFinished.pop();
            while(true){
                if(std<whenFinished.peek()){
                    answer.add(i);
                    i=1;
                    std = whenFinished.pop();
                }else{
                    whenFinished.pop();
                    i++;
                }
            }
        }catch(EmptyStackException e){
            answer.add(i);
        }finally{
            return answer;
        }

    }
}