package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DAY230212_BOJ7562_나이트의이동 {
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int currX = Integer.parseInt(st.nextToken());
            int currY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(n, currX, currY, targetX, targetY));
        }
    }

    private static class Node {
        private int x;
        private int y;
        private int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    private static int bfs(int n, int currX, int currY, int targetX, int targetY) {
        Queue<Node> q = new LinkedList<>();
        visited[currX][currY] = true;
        q.add(new Node(currX, currY, 0));

        int ans = 0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            // 꺼낸 원소가 타겟과 같은지 체크하기
            if (poll.x == targetX && poll.y == targetY) {
                ans = poll.cnt;
                break;
            }
            // 8방 탐색을 한다
            // 범위체크
            // 방문체크
            // 갈 수 있다면 큐에 넣기
            for (int d = 0; d < 8; d++) {
                int nx = poll.x + dx[d];
                int ny = poll.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                q.add(new Node(nx, ny, poll.cnt + 1));
                // 방문처리
                visited[nx][ny] = true;
            }
        }
        return ans;
    }
}
