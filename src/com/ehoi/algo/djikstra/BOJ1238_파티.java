package com.ehoi.algo.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1238_파티 {
    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int n, m, x;
    static List<List<Edge>> graph, reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        n = Integer.parseInt(firstLine[0]); // 학생 수 = 마을 수
        m = Integer.parseInt(firstLine[1]); // 도로 개수
        x = Integer.parseInt(firstLine[2]); // 파티 장소

        // 그래프 초기화
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 도로 정보 입력 받기
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int cost = Integer.parseInt(info[2]);

            graph.get(start).add(new Edge(end, cost));
            reverseGraph.get(end).add(new Edge(start, cost));
        }

        // 다익스트라 하고 오기
        int[] dijkstra = dijkstra(graph, x);
        int[] reverse = dijkstra(reverseGraph, x);

        // 가장 오래 걸리는 시간 구하기
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dijkstra[i] + reverse[i]);
        }

        System.out.println(ans);
    }

    // 최단거리 배열 리턴
    private static int[] dijkstra(List<List<Edge>> graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll(); // cost가 짧은게 먼저 나와야 함

            if (curr.cost > dist[curr.to]) continue;

            for (Edge next : graph.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.cost) {
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}