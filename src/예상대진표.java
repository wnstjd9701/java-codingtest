public class 예상대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8,4,7));
    }
    public static int solution(int n, int a, int b){
        int answer = 0;

        while(true){
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if(a==b) break;
        }

        return answer;
    }
}
