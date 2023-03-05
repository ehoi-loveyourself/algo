package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lec80_다익스트라 {
    static List<Edge>[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 간선 정보 입력받기 위해서 리스트 선언
        info = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            info[i] = new ArrayList<>();
        }

        // 이제 입력받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            info[me].add(new Edge(next, weight));
        }

        dijkstra(1, v);
    }

    private static void dijkstra(int start, int v) {
        // 거리배열과 방문 배열을 초기화
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리를 최댓값으로 채움
//        boolean[] visited = new boolean[v + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0; // 시작하는 정점의 거리를 0으로 초기화
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            // 방문하지 않은 배열 중에서 가장 최솟값을 찾아
            /*
            이런식으로 최솟값을 찾는게 비효율적이래
            우선순위큐를 사용하자
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 1; i <= v; i++) {
                if (!visited[i]) {
                    if (min > dist[i]) {
                        min = dist[i];
                        minIdx = i;
                    }
                }
            }
             */
            Edge poll = pq.poll();
            /*
            **코드를 효율적으로 돌리기 위해서 방문 배열을 사용했지만 그것보다 더 유용한 것이 있다**
            // 방문했다면 continue;
            if (visited[poll.node]) continue;;
            // 최솟값인 idx 방문
            visited[poll.node] = true;
             */

            // 현재 뽑은 엣지의 거리 배열의 비용을 살펴보니 뽑은 엣지의 비용보다 적더라
            // 그럼 이미 최소로 만들어진 상태니까 보지 말자!
            // 근데 난 이게 기억이 안나서 방문 배열을 만들 것 같긴 함 ㅠ
            if (dist[poll.node] < poll.weight) continue;

            // 그 idx와 연결된 애들 탐색
            for (Edge e : info[poll.node]) {
                // e.node에 저장되어 있는 거리보다 지금 minIdx에서 출발해서 거기까지 가는 거리가 더 짧다면
                if (dist[poll.node] + e.weight < dist[e.node]) {
                    dist[e.node] = dist[poll.node] + e.weight;
                    pq.add(e);
                }
            }
        }

        // 거리배열 출력
        for (int i = 1; i <= v; i++) {
            if (i == start) continue;
            if (dist[i] == Integer.MAX_VALUE) System.out.printf("%d : impossible\n", i);
            else System.out.printf("%d : %d\n", i, dist[i]);
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int node;
        private int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
