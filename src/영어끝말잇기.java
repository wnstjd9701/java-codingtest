import java.util.*;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(words));
        solution(3, words);
    }
    public static int[] solution(int n, String[] words){
        int[] answer = {0, 0};
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++){
            if(i!=0){
                String prev = words[i-1];
                String curr = words[i];

                char last = prev.charAt(prev.length() - 1);
                char first = curr.charAt(0);

                if(map.containsKey(curr) || last != first){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;

                    return answer;
                }
            }
            map.put(words[i], 1);
        }
        return answer;
    }
}
