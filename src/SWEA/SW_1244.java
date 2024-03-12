package SWEA;

import java.util.Scanner;

public class SW_1244 {
    static String[] arr;
    static int count;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1 ; test_case <= T ; test_case++){
            arr = sc.next().split("");
            count = sc.nextInt();

            if(arr.length < count){
                count = arr.length;
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }
    public static void dfs(int start, int cnt){
        if(cnt == count){
            String result = "";
            for(String s: arr)
                result += s;
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for(int i=start; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                swap(i, j);
                dfs(i, cnt+1);
                swap(i, j);
            }
        }
    }
    public static void swap(int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
