package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230223_BOJ14500_테트로미노 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        // 각 지점부터 dfs를 보내기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]); // 여기서 이미 한번 고르고 들어가잖아
                visited[i][j] = false;

                // dfs로 불가능한 ㅗ모양은 따로 보내기
                combi(i, j, 0, 0, map[i][j]);
            }
        }
        // 정답 출력하기
        System.out.println(ans);
        br.close();
    }

    private static void combi(int r, int c, int cnt, int start, int sum) {
        if (cnt == 3) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int d = start; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            // 범위 체크
            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

            combi(r, c, cnt + 1, d + 1, sum + map[nr][nc]);
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void dfs(int r, int c, int cnt, int sum) {
        // 4번까지 탐색했으면
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        // 재귀 반복
        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            // 범위 체크
            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            // 방문 체크
            if (visited[nr][nc]) continue;
            // 탐색 가능
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
