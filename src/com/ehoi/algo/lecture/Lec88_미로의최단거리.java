package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lec88_미로의최단거리 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 출력
        System.out.println(bfs());

        br.close();
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        // 방문처리
        map[0][0] = 1;

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            // 도착 지점이면
            if (poll.x == 6 && poll.y == 6) {
                // 먼저 도착한 애가 최단거리지
                return poll.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = poll.x + dx[d];
                int ny = poll.y + dy[d];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= 7 || ny >= 7) continue;
                // 갈 수 있는 길 0인지 체크
                if (map[nx][ny] == 1) continue;
                // 갈 수 있으니까 큐에 넣기
                q.add(new Pair(nx, ny, poll.cnt + 1));
                // 방문처리하기 = 벽으로 만들기
                map[nx][ny] = 1;
            }
        }
        return -1;
    }

    private static class Pair {
        private int x;
        private int y;
        private int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
