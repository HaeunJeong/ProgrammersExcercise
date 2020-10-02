import java.util.HashMap;
import java.util.Collections;


class Solution {

    class Song extends Comparable<Song>{
        int id, play;
        String genre;

        Song(int id, int play, String genre){
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
        @Override
        public int compareTo(Song o){
            return this.play-o.play;
        }
        //A.compareTo(B) > 0 -> A.play>B.play 
        
    }



    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> totalPlays = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i],0)+plays[i]);
        }
        System.out.println(totalPlays);
        
        return answer;
    }
}