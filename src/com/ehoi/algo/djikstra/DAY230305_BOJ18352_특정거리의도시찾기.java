package com.ehoi.algo.djikstra;

import java.io.*;
import java.util.*;

public class DAY230305_BOJ18352_특정거리의도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        // 도로의 개수만큼 정보를 받는다
        List<Edge>[] info = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            info[s].add(new Edge(e));
        }

        // x부터 다익스트라를 돌린다.
        dijkstra(x, n, info, k);
    }

    private static void dijkstra(int start, int n, List<Edge>[] info, int k) {
        // 거리배열을 만들고 최댓값으로 초기화한다
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작점의 거리를 0으로 초기화한다.
        dist[start] = 0;
        // 가중치가 없다! 그럼 그냥 큐에 넣자
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(start));
        // 그리고 방문배열을 만들자
        boolean[] visited = new boolean[n + 1];

        // 큐가 빌때까지
        while (!q.isEmpty()) {
            Edge poll = q.poll();

            if (visited[poll.node]) continue;
            visited[poll.node] = true;
            // 이 노드와 연결된 노드들에게 현재 dist + 1을 한것과 최소 비교한다.
            for (Edge e : info[poll.node]) {
                // 방문하지 않은 것에 대해서만
                if (visited[e.node]) continue;
                if (dist[e.node] > dist[poll.node] + 1) {
                    dist[e.node] = dist[poll.node] + 1;
                    q.add(e);
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) System.out.println(-1);
    }

    private static class Edge {
        private int node;

        public Edge(int node) {
            this.node = node;
        }
    }
}
