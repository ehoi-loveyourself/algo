package com.ehoi.algo;

import java.util.*;

public class DAY221013_PRO_BFS_게임맵최단거리 {
    static int answer = 987654321;
    static boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps, 0, 0); // x좌표 0, y좌표 0

        return answer == 987654321 ? -1 : answer;
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static void bfs(int[][] maps, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == maps.length - 1 && curr.y == maps[0].length - 1) {
                answer = Math.min(answer, curr.cost);
                return;
            }


            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                queue.offer(new Node(nx, ny, curr.cost + 1));
                visited[nx][ny] = true;
            }
        }
    }

    public static class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
