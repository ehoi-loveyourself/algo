package com.ehoi.algo.simulation;

import java.io.*;
import java.util.*;

public class BOJ14503_로봇청소기2 {

    static int N, M;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        // 청소하러 가자
        ans = 0;
        clean(r, c, d);
        System.out.println(ans);
    }

    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void clean(int r, int c, int d) {
        // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (map[r][c] == 0) {
            map[r][c] = 2; // 청소 했다는 의미로 벽과 같이 1로 만들자, 아님 벽이면 이동을 못하니까 벽이라고 생각하게 하면 안됨
            ans++;
        }

        // 2. 현재 칸의 주변 4칸 탐색
        // 근데 반시계 방향으로 돌아야해
        for (int dir = 0; dir < 4; dir++) {
            d = (d + 3) % 4;
            int nr = r + dx[d];
            int nc = c + dy[d];

            // 범위를 벗어나지 않는지 + 벽이 아닌지 검증부터
            if (!movable(nr, nc)) continue;

            // 청소되지 않은 빈 칸인 경우
            if (map[nr][nc] == 0) {
                // 한칸 전진해서 청소
                clean(nr, nc, d);
                return;
            }
        }

        // 3. 4방 탐색을 완료하고도 청소할 곳이 없다는 것
        // 그 방향 그대로 한칸 후진 할 수 있다면 한칸 후진
        if (movable(r - dx[d], c - dy[d])) {
            // 1번으로 돌아간다.
            clean(r - dx[d], c - dy[d], d);
        }
    }

    private static boolean movable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && map[r][c] != 1;
    }
}