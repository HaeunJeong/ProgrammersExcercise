import java.util.*;
class Solution {
    class Doc{
        private int id;
        private int prio;

        public Doc(int id, int prio){
            this.id = id;
            this.prio = prio;
        }
        public int getId(){
            return this.id;
        }
        public int getPrio(){
            return this.prio;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = -1;

        Queue<Doc> waiting = new ArrayDeque<>();
        int i=0;
        for(int p: priorities){
            waiting.offer(new Doc(i++, p));
        }

        //int destPrio = priorities[location]; //뽑으려는 인쇄물의 우선순위
        int time=0;
        while(answer==-1){
            int size = waiting.size();
            Doc popDoc = waiting.poll();

            for(Doc j: waiting){
                if(j.getPrio()>popDoc.getPrio()){
                    waiting.offer(popDoc);
                    break;
                }
            }
            if(waiting.size()<size){
                time++; // 뽑는것
                if(popDoc.getId()==location){
                    answer = time;
                }
            }
        }

        return answer;
    }
}