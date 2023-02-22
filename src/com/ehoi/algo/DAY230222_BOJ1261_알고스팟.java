package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DAY230222_BOJ1261_알고스팟 {
    static boolean[][] visited;
    static int[][] map;
    static int n, m;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 열
        n = Integer.parseInt(st.nextToken()); // 행
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        } // 입력 완료

        bfs();

        System.out.println(ans);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs() {
        PriorityQueue<Node4> q = new PriorityQueue<>();
        q.add(new Node4(0, 0, 0));
        visited[0][0] = true;

        // 우선순위큐가 아니라 그냥 큐 자료구조를 가지고 돈다면
        // 방문배열로 인해 막혔을 때 어쩌다 큐에서 먼저 나온 애한테 가로막혀서 정답 경로를 탐색하지 못하는 거 일 수 있어
        // 이럴 때는 우선순위 큐를 사용하자!
        // 그리고 알고 강의를 다시 듣기 시작하자!
        while (!q.isEmpty()) {
            Node4 now = q.poll();

            if (now.x == n - 1 && now.y == m - 1) { // 도착지에 도착하면
                ans = Math.min(ans, now.broken); // 지금까지 부순 개수와 정답의 최솟값을 비교하고
//                continue; // 나머지 큐에 있는 거 더 검사하러 간다
                // 최소로 벽을 부순 큐에 제일 먼저 나올 테니
                return;
            }

            for (int d = 0; d < 4; d++) { // 사방 탐색을 돌면서
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 미로의 바깥은 못 나가고
                if (visited[nx][ny]) continue; // 방문했던 곳은 굳이 다시 가지 말고
                if (map[nx][ny] == 1) { // 벽이라면
                    q.add(new Node4(nx, ny, now.broken + 1)); // 부수고 들어가고
                } else { // 벽이 아니면 그냥 들어가
                    q.add(new Node4(nx, ny, now.broken));
                }
                visited[nx][ny] = true; // 그리고 방문처리는 해주고
            }
        }
    }

    private static class Node4 implements Comparable<Node4> {
        private int x;
        private int y;
        private int broken;

        public Node4(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }

        @Override
        public int compareTo(Node4 o) {
            return this.broken - o.broken; // 오름차순이고 싶으면 내가 앞에, 내림차순이고 싶으면 내가 뒤에
        }
    }
}
