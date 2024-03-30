package Programmers;

import java.util.Stack;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		solution("baabaa");
	}
	
	public static int solution(String s) {
		int answer = 0;
		
		char[] cArr = s.toCharArray();
		int len = cArr.length;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<len; i++) {
			char c = cArr[i];
			if(stack.isEmpty()) {
				stack.push(c);
			}else {
				if(stack.peek() == c) {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
			
		}
		
		return stack.isEmpty() ? 1:0;
	}

}
