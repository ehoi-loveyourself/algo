package com.ehoi.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 최단거리를 구하는 문제는 BFS로 풀어야 한다고 한다!
public class DAY230201_BOJ2178_미로탐색 {
    static int n, m;
    static int[][] map;
    static int[][] distance; // 이게 정답이 될거야

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 입력을 받자. 맵 정보가 붙어서 들어온다는 것에 주의!
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                distance[i][j] = -1; // 거리를 체크할 거라서 안전하게 -1로
            }
        }

        // 2. (1, 1)에서 출발하자
        bfs(0, 0);

        System.out.println(distance[n - 1][m - 1]);

        sc.close();
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        // 방문처리
        distance[r][c] = 1;
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = currX + dx[d];
                int ny = currY + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (distance[nx][ny] != -1 || map[nx][ny] == 0) continue;
                // 이제 갈 수 있어
                queue.add(new int[]{nx, ny});
                // 방문처리
                distance[nx][ny] = distance[currX][currY] + 1;
            }
        }
    }
}
