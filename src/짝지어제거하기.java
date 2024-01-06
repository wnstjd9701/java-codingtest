import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        int result = solution("baabaa");
        System.out.println(result);

    }
    public static int solution(String s){
        int answer = -1;
        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<cArr.length; i++){
            char c = cArr[i];
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
