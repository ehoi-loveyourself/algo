package com.ehoi.algo;

import java.io.*;
import java.util.StringTokenizer;

public class DAY230217_BOJ14503_로봇청소기 {
    // 북, 동, 남, 서 시게 방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        clean(r, c, dir);

//        System.out.println(cnt);
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }

    private static void clean(int x, int y, int dir) {
        // 1. 현재 칸이 청소가 되지 않았다면 청소를 한다.
        if (map[x][y] == 0) {
            map[x][y] = 2;
            cnt++;
        }

        // 2. 반시계 방향으로 돌면서 청소되지 않은 곳이 있다면 한칸 전진하고
        // 네바퀴를 다 돌아도 빈칸이 없다면 후진
//        boolean flag = false;
//        int tmpDir = dir; // 어차피 제자리로 돌아올거라서 상관없구나
        for (int d = 0; d < 4; d++) {
            dir = (dir + 3) % 4; // 반시계로 회전
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] == 0) {
//                flag = true;
                clean(nx, ny, dir);
                // 그리고 청소하러 재귀로 들어갔으니, 재귀를 빠져나왔을 때 반복문을 마저 돌지 않도록 break처리를 해줘야 한다.
                // 브레이크가 아니라 리턴을 시켜주면 계속 백시켜주니까 이게 더 좋겠다.
                return;
            }
        }

        // 3. 주변을 다 탐색해도 빈칸이 없다면
//        if (!flag) {
        // 후진할 수 있는지 보자
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if (0 <= bx && bx < n && 0 <= by && by < m) {
            if (map[bx][by] != 1) {
                // 여기선 방향을 돌리지 않았으니까 원 방향 그대로
                clean(bx, by, dir);
            }
        }
//        }
    }
}
