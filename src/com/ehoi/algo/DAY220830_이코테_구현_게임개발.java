package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY220830_이코테_구현_게임개발 {
    static int x, y, dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 크기 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        // 캐릭터의 위치 받기
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());


        // 맵 정보 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료



        // 정답이 될 ans = 1 : 시작부터 방문한 칸의 수로
        int ans = 1;

        // 현재 위치도 방문한 것으로 체크
        map[x][y] = 1; // 바다도 방문한 것도 모두 1로 체크

        int turn_time = 0; // 회전하는 수

        // 계속 반복한다
            // 왼쪽으로 회전한다
            // nx, ny가 0이라면
                // x, y를 nx, ny로 갱신하고
                // x, y 좌표를 1로 만들고
                // ans++ 한다.
                // 회전한 수를 0으로 세팅하고
                // 다시 위로 올라간다. continue;
            // 아니라면
                // 회전한 수를 ++한다.

            // 모두 실패해서 회전한 수가 4번이라면
                // 뒤로가는 nx, ny가 0이라면
                    // x, y를 갱신한다.
                // 아니라면
                    // 끝이다.
                // turn_time을 다시 0으로 세팅
        while (true) {
            turnLeft();
            int nx = x + dr[dir];
            int ny = y + dc[dir];
            if(map[nx][ny] == 0) {
                x = nx;
                y = ny;
                map[x][y] = 1;
                ans++;
                turn_time = 0;
                continue;
            } else {
                turn_time++;
            }

            if (turn_time == 4) {
                nx = x - dr[dir];
                ny = y - dc[dir];
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
                turn_time = 0;
            }
        }
        System.out.println(ans);
    }

    // 캐릭터 방향 설정하기
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void turnLeft() {
        dir--;
        if (dir < 0) {
            dir = 3;
        }
    }
}
