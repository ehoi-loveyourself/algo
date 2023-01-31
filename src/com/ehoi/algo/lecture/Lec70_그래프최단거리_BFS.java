package com.ehoi.algo.lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec70_그래프최단거리_BFS {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        ans = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            map[s][e] = 1;
        }
        visited[1] = true;
        bfs(1);
        for (int i = 2; i < ans.length; i++) {
            System.out.printf("%d : %d\n", i, ans[i]);
        }
        sc.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

//        int cnt = 1;
        while (!queue.isEmpty()) {
            // 큐에서 정점 하나를 뽑는다.
            int curr = queue.poll();
            boolean flag = false;
            // 그 정점에서 갈 수 있는 다른 정점들을 알아본다.
            for (int i = 1; i <= n; i++) {
                if (map[curr][i] != 0) {
                    if (visited[i]) continue;
                     // 방문처리한다.
                    visited[i] = true;
                    // 갈 수 있는 정점들에 현재 cnt를 먹인다.
//                    ans[i] = cnt;
                    /* 리팩토링 한 것!!!!
                    * 내가 한 것처럼 해도 되지만
                    * 지금까지 온 정점에서 + 1을 해야 나까지 오는 거리가 되니까
                    * 이런 식으로 해주면 더 직관적이고 깔끔!
                    * */
                    ans[i] = ans[curr] + 1;
                     // 그 정점들을 다시 큐에 넣는다.
                    queue.add(i);
//                    flag = true; // 여기까지 왔다는 것은 처리가 있었다는 뜻
                }
            }
            // cnt++한다.
            // 문제점 : 저기 포문안에서 어떤 처리가 없어도 cnt는 무조건 ++이 되는 상황임
//            if (flag) cnt++;
        }
    }
}
