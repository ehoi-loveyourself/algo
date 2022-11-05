package com.ehoi.algo;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class DAY221104_BOJ1238_G3_파티 {
    static int V, E, X;
    static List<Node>[] list;
    static int[][] dist;
    static boolean[][] visited;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 마을
        E = Integer.parseInt(st.nextToken()); // 도로
        X = Integer.parseInt(st.nextToken()); // 도착할 마을

        list = new ArrayList[V + 1];
        dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
            list[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1][V + 1];

        // 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
        }

        for (int i = 1; i <= V; i++) {
            dijkstra(i); // 갱신
        }

        int[] ans = new int[V + 1];
        int max = 0;
        for (int i = 1; i <= V; i++) {
            ans[i] = dist[i][X] + dist[X][i];
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
    }

    public static void dijkstra(int start) {
        // 거리가 무한인 시작점을 일단 0으로 세팅을 하자
        dist[start][start] = 0;

        // 이제 거리를 우선으로 정렬할 우선순위 큐를 만들자
        PriorityQueue<Node> q = new PriorityQueue<>();
        // 일단 시작점이 제일 짧으니까 나를 강제로 넣어버리자
        q.add(new Node(start, dist[start][start]));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int curr = node.end; // curr이 시작점이야

            // 여기 갱신한 적 있는지 확인하자
            if (visited[start][curr]) continue;
            visited[start][curr] = true;

            // curr 에서 갈 수 잇는 곳 싹 다 돌자
            for (Node n : list[curr]) {
                // 갱신하자 : n.end까지의 dist vs [start][curr] + n.weight
                if (dist[start][n.end] > dist[start][curr] + n.weight) {
                    dist[start][n.end] = dist[start][curr] + n.weight;
                }
                q.add(new Node(n.end, dist[start][n.end]));
            }
        }
    }
}
