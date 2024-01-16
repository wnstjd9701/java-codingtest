public class 점프와순간이동 {
    public static void main(String[] args) {
        solution(5);
    }
    public static int solution(int n){
        int answer = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                answer--;
            }
        }

        return answer;
    }
}
