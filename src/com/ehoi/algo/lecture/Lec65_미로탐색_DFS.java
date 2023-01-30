package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec65_미로탐색_DFS {
    static int n = 7;
    static int[][] map = new int[n + 1][n + 1];
    static boolean[][] visited = new boolean[n + 1][n + 1];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited[1][1] = true;
        dfs(1, 1);
        System.out.println(ans);
        sc.close();
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int x, int y) {
        // 종료 조건 : 도착점에 도착했을 때
        if (x == n && y == n) {
            ans++;
            return;
        }

        // 재귀 조건 : 1. 범위 체크 2. 통로인지 3. 방문했는지
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 체크
//            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 무지성으로 작성한 코드.. 바보 멍청이..
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;

            // 벽이라면
            if (map[nx][ny] == 1) continue;

            // 방문했다면
            if (visited[nx][ny]) continue;

            // 난 갈 수 있어!!
            visited[nx][ny] = true;
            dfs(nx, ny);
            visited[nx][ny] = false;
        }
    }
}
