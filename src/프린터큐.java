import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
    static int t; // 테스트 케이스 수
    static int n; // 문서의 개수
    static int m; // 궁금한 문서의 초기 위치
    static Queue<Integer> queue; // 문서의 중요도
    static Queue<Integer> indexQueue; // 문서의 인덱스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            indexQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                queue.offer(Integer.parseInt(st.nextToken()));
                indexQueue.offer(j);
            }
            solve();
        }
    }
    public static void solve(){
        int count = 1;

        while (!queue.isEmpty()) {
            int max  = Collections.max(queue);
            int cur = queue.poll();
            int curIndex = indexQueue.poll();

            if(cur == max){
                if (curIndex == m) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
            else{
                queue.offer(cur);
                indexQueue.offer(curIndex);
            }
        }
    }

}
