package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lec89_토마토 {
    private static int m, n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 모두 익은 토마토면 flag = true;
        boolean flag = true;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    // 안익은 토마토가 있다면
                    flag = false;
                }
            }
        }
        // 모두다 익었다면 0 충력
        if (flag) {
            System.out.println(0);
            System.exit(0);
        }

        // 섞여 있다면 익은 토마토로 나머지를 익히러 가자
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) bfs(i, j);
            }
        }

        // 다 돌고 나옴
        // 하나라도 안 익은 게 있다면 -1을
        // 다 익었다면 max에서 -1을 해서 정답으로 도출 해야하는데
        flag = true; // 다 익었을 걸?
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    flag = false;
                    break;
                }
                ans = Math.max(ans, map[i][j]);
            }
        }

        if (!flag) System.out.println(-1);
        else System.out.println(ans - 1);
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            for (int d = 0; d < 4; d++) {
                // 사방탐색하면서 안익은 토마토가 있다면 익혀주기
                int nx = poll.x + dx[d];
                int ny = poll.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 익은 것도 패스
                if (map[nx][ny] > 0) continue;
                // 안익은 거 익히기 : 하루 뒤에 익으니까 + 1 시키기
                map[nx][ny] = map[poll.x][poll.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
