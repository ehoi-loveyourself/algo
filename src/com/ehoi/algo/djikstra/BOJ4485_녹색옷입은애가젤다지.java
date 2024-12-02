package com.ehoi.algo.djikstra;

import java.io.*;
import java.util.*;

public class BOJ4485_녹색옷입은애가젤다지 {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] cave;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int problem = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] info = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(info[j]);
                }
            }

            // 다익스트라
            int ans = dijkstra();
            sb.append("Problem ").append(problem++).append(": ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    // 최소로 잃는 금액 계산해서 리턴
    public static int dijkstra() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, cave[0][0]));

        dist[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int currCost = curr.cost;

            // 지금 비용이 최단 비용보다 크다면 고려할 필요 없음
            if (currCost > dist[x][y]) continue;

            // 사방탐색 해야함
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newCost = currCost + cave[nx][ny];

                    if (dist[nx][ny] > newCost) {
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}