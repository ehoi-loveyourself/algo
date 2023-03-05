package com.ehoi.algo.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class DAY230305_BOJ1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수 == 정점
        int m = Integer.parseInt(br.readLine()); // 버스의 개수 == 간선

        // 버스 정보 입력받기
        List<Edge>[] info = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[s].add(new Edge(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();

            // poll.cost 의 의미는 poll.node까지 가는 거리다.
            // 근데 dist[poll.node]는 지금까지 계산된 poll.node까지의 최솟값 거리다.
            // 그러므로 dist[poll.node]의 값이 더 작다면 더 볼 필요가 없다!
            // 이미 방문했으니 넘어가라의 느낌
            if (dist[poll.node] < poll.cost) continue;
            for (Edge e : info[poll.node]) {
                // 최솟값 비교
                // e.node까지 가는 거리 : dist[e.node]
                // poll.node를 거쳐 e.node까지 가는 거리 : dist[poll.node] + e.cost
                if (dist[e.node] > dist[poll.node] + e.cost) {
                    dist[e.node] = dist[poll.node] + e.cost;
                    // 큐에 넣는거 까먹지 말기
                    pq.add(e);
                }
            }
        }

        // 거리 최소화 끄읕!
        System.out.println(dist[end]);
    }

    private static class Edge implements Comparable<Edge> {
        private int node;
        private int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
