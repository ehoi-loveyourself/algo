package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘과 유사한 프림
//
public class Lec79_원더랜드_PrimMST {
    static int v;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); // 노드 수
        int e = Integer.parseInt(st.nextToken()); // 간선 수

        // 크루스칼은 간선 정보를 입력받아 가중치를 오름차순으로 정렬해서 해결했지만
        // 프림은 우선순위 큐를 이용하여 가중치가 가장 작은 노드부터 꺼낸다.
        graph = new ArrayList[v + 1];
        // 초기화
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력을 받는다.
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[me].add(new Edge(next, weight));
            // 나만 연결하는게 아니고 반대쪽에서도 연결을 해줘야 함
            graph[next].add(new Edge(me, weight));
        }

        prim(1);
    }

    private static void prim (int start) {
        // 우선순위 큐 초기화
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 이미 연결된 정점은 피하기 위해 방문 배열 선언
        boolean[] visited = new boolean[v + 1];

        int ans = 0;
        // 아무 정점에서나 시작해도 된다고 함. 이때 가중치는 0으로 시작
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            // 1번 정점이 가장 먼저 튀어나옴
            Edge curr = pq.poll();

            int me = curr.v;
            int weight = curr.weight;

            // 이 정점이 MST에 추가 됐으면 == 연결 됐으면 넘겨
            if (visited[me]) continue;

            // 아니라면 이제 들어갈거야
            visited[me] = true;
            ans += weight;

            // 이제 이 정점과 연결된 다른 정점들 중 방문하지 않은 것들만 넣을거야
            for (Edge edge : graph[me]) {
                if (!visited[edge.v]) {
                    pq.add(edge);
                }
            }
        }
        System.out.println(ans);
    }

    private static class Edge implements Comparable<Edge> {
        private int v;
        private int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
