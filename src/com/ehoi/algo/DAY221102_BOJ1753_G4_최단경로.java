package com.ehoi.algo;

import java.io.*;
import java.util.*;

class Node2 implements Comparable<Node2> {
    int end;
    int weight;

    public Node2(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node2 o) {
        return weight - o.weight; // 음수여야 앞에 배치
    }
}

public class DAY221102_BOJ1753_G4_최단경로 {
    static int V, E;
    static List<Node2>[] list;

    static int[] dist;
    static boolean[] visited;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        // 2. 무한으로 초기화
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        // 3. 정보 세팅
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node2(e, w));
        }

        dijkstra(start);

        // dist[] 갱신 끝

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }

    private static void dijkstra(int start) {
        // 1. 시작점은 0으로 세팅
        dist[start] = 0;

        // 2. 우선순위 큐
        PriorityQueue<Node2> q = new PriorityQueue<>();
        // 시작 노드에서 시작 노드로 가는 최단 거리는 0이다 로 세팅하고 시작!
        q.add(new Node2(start, 0));

        while (!q.isEmpty()) {
            Node2 node = q.poll(); // weight 가 제일 작은 친구부터 나옴
            int curr = node.end;

            // 방문했는지 체크
            if (visited[curr]) continue;
            visited[curr] = true;

            // curr이 시작점, n.end가 도착점
            for (Node2 n: list[curr]) {
                // 그래서 n.end의 거리가 curr의 거리 + n.weight 보다 크다면 갱신
                if (dist[n.end] > dist[curr] + n.weight) {
                    dist[n.end] = dist[curr] + n.weight;
                    q.add(new Node2(n.end, dist[n.end]));
                }
            }
        }
    }
}
