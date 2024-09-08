package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499_주사위굴리기 {
    // 동, 서, 북, 남
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Tool tool = new Tool(0, 0, 0, 0, 0, 0);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            int comm = Integer.parseInt(st.nextToken());

            // 주사위를 이동시키는 것과 굴리는 것을 별개로 생각하고
            int nx = x + dx[comm];
            int ny = y + dy[comm];

            // 1. 이동
            // 지도 바깥으로 나가면 안돼
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // 지도 안에 있다면 이동
            x = nx;
            y = ny;

            // 2. 굴리기
            if (comm == 1) { // 동
                int temp = tool.top;
                tool.top = tool.left;
                tool.left = tool.bottom;
                tool.bottom = tool.right;
                tool.right = temp;
            } else if (comm == 2) { // 서
                int temp = tool.top;
                tool.top = tool.right;
                tool.right = tool.bottom;
                tool.bottom = tool.left;
                tool.left = temp;
            } else if (comm == 3) { // 북
                int temp = tool.top;
                tool.top = tool.back;
                tool.back = tool.bottom;
                tool.bottom = tool.front;
                tool.front = temp;
            } else if (comm == 4) { // 남
                int temp = tool.top;
                tool.top = tool.front;
                tool.front = tool.bottom;
                tool.bottom = tool.back;
                tool.back = temp;
            }

            // 3. 숫자 전염시키기
            // 지도 위의 숫자가 0이면 주사위 바닥에 있는 수가 지도에 복사
            if (map[x][y] == 0) {
                map[x][y] = tool.bottom;
            } else {
                tool.bottom = map[x][y];
                map[x][y] = 0;
            }

            // 4. 주사위 위의 값 출력하기
            sb.append(tool.top).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Tool { // 주사위
        int left, right, top, bottom, front, back;

        Tool(int left, int right, int top, int bottom, int front, int back) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            this.front = front;
            this.back = back;
        }
    }
}