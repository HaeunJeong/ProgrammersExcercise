import java.util.*;
class Solution {

    public class Pair{

        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() { return (int)key; }
        public int getValue() { return (int)value; }

        public void setValue(int val){
            this.value = val;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(100,100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int finishNum = truck_weights.length;
        System.out.println(String.format("총 트럭: %d",finishNum));
        ArrayList<Integer> finishedTruck = new ArrayList<>();
        Queue<Integer> waitingTruck = new ArrayDeque<>();
        for(int t : truck_weights){
            waitingTruck.add(t);
        }
        Queue<Pair> crossingTruck = new ArrayDeque<>();

        int time=1; //경과시간
        try{

            while(true){


                for(Pair p: crossingTruck){
                    if(time - p.getValue()>=bridge_length){
                        finishedTruck.add(crossingTruck.poll().getKey());
                    }
                }
                //-> 한 경과시간 후, 다리를 지난 트럭

                if(waitingTruck.peek()!=null && crossingTruck.stream().mapToInt(Pair::getKey).sum()
                        + waitingTruck.peek()
                        <=weight){
                        crossingTruck.add(new Pair(waitingTruck.poll(),time));
                        // System.out.println(crossingTruck.peek().getKey() + ", "+crossingTruck.peek().getValue());
                    //-> 한 경과시간 후, 다리를 건너는 트럭
                }


                System.out.print(String.format("시간: %d\t",time));


                System.out.print("지난 트럭: ");
               Iterator<Integer> sd = finishedTruck.iterator();
                while(sd.hasNext()){
                    System.out.print(sd.next());
                    System.out.print(",\t");
                }
                System.out.print("\t");


                System.out.print("지나는트럭: ");
                Iterator<Pair> s = crossingTruck.iterator();
                while(s.hasNext()){
                    System.out.print(s.next().getKey());
                    System.out.print(",\t");
                }
                System.out.print("\n");


                if(finishedTruck.size()<finishNum){
                    time++;
                }
                else{
                    break;
                }
            }
        }catch(NoSuchElementException e){
            System.out.println(e);
        }



        answer = time;
        return answer;
    }
}