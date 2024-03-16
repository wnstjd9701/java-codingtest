package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249 {
	public static int n;
	public static int[][] graph;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static class Node {
		int x;
		int y;
		int dis;
		public Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=testCase; test++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] temp = br.readLine().split("");
				for(int j=0; j<n; j++) {
					graph[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			int answer = bfs();
			sb.append("#" + testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int bfs() {
		int[][] visited = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		Queue<Node> q = new LinkedList<>();
		visited[0][0] = 0;
		q.offer(new Node(0,0,0));
		int dis = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if((node.x == n-1) && (node.y == n-1)) {
				dis = Math.min(dis, node.dis);
				continue;
			}
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					int distance = node.dis + graph[nx][ny];
					if(visited[nx][ny] > distance) {
						visited[nx][ny] = distance;
						q.add(new Node(nx, ny, distance));
					}
				}
			}
		}
		return dis;
	}
}