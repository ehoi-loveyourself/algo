package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DAY230213_BOJ2667_단지번호붙이기 {
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        } // 입력 완료

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                // 집이 아니면
                if (map[nx][ny] == 0) continue;
                // 방문 처리
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                cnt++;
                q.add(new int[] {nx, ny});
            }
        }
        list.add(cnt);
    }
}
