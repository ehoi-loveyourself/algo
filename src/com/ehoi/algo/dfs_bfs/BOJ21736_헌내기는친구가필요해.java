package com.ehoi.algo.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21736_헌내기는친구가필요해 {
    static char[][] map;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        int me_r = -1;
        int me_c = -1;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char cur = line.charAt(j);
                map[i][j] = cur;
                if (cur == 'I') {
                    me_r = i;
                    me_c = j;
                }
            }
        }

        answer = 0;
        dfs(me_r, me_c);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static void dfs(int r, int c) {
        // 종료 조건 : 갈 수 없으면
        if (!movable(r, c)) return;
        visited[r][c] = true;
        if (map[r][c] == 'P') answer++;
        for (int d = 0; d < 4; d++) {
            dfs(r + dx[d], c + dy[d]);
        }
    }

    // 1. 범위 밖, 2. 벽, 3. 방문했던 곳
    private static boolean movable(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return false;
        if (map[r][c] == 'X') return false;
        if (visited[r][c]) return false;
        return true;
    }
}