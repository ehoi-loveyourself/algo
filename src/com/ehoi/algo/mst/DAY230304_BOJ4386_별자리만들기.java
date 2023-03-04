package com.ehoi.algo.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프림
public class DAY230304_BOJ4386_별자리만들기 {
    static List<Star>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 별의 개수

        // 별의 정보를 입력할 배열과
        double[][] stars = new double[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        // 별들끼리의 거리를 넣어들 그래프를 선언
        graph = new ArrayList[n + 1];
        // 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                double dist = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));

                graph[i].add(new Star(j, dist));
                graph[j].add(new Star(i, dist));
            }
        }

        // 프림 알고리즘 돌리기
        prim(1, n); // 1번 별부터 n번 별까지 탐색

        // 소수점 둘째자리까지만 출력한다
    }

    private static void prim(int start, int n) {
        // 우선순위 큐 초기화
        PriorityQueue<Star> pq = new PriorityQueue<>();
        // 방문 배열 초기화
        boolean[] visited = new boolean[n + 1];

        pq.add(new Star(start, 0));
        // 여기서 방문 배열을 true로 만들면 안됨. 일단 시작할 임의의 정점을 넣는 것에 불과하기 때문에

        double ans = 0;
        while (!pq.isEmpty()) {
            Star poll = pq.poll();

            int v = poll.node;
            double dist = poll.dist;

            // 이 노드 MST에 연결되어 있냐?
            if (visited[v]) continue;

            // 연결 안되어 있으면 연결해라
            visited[v] = true;
            ans += dist;

            // 그리고 이 정점과 연결된 아이들 중에 아직 MST에 포함안된 애들을 Pq에 넣어라
            for (Star s : graph[v]) {
                if (!visited[s.node]) {
                    pq.add(s);
                }
            }

        }
        System.out.printf("%.2f", ans);
    }

    // 로 클래스를 만든다
    private static class Star implements Comparable<Star> {
        private int node;
        private double dist;

        public Star(int node, double dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.dist, o.dist);
        }
    }
}
