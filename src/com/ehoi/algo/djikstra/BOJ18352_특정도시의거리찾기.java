package com.ehoi.algo.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352_특정도시의거리찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

        List<Integer>[] info = new ArrayList[n + 1];
        // 초기화 해주기
        for (int i = 1; i <= n; i++) {
            info[i] = new ArrayList<>();
        }

        // 거리 정보 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            info[s].add(e);
        }

        // 출발도시부터 다익스트라 돌리기
        dijkstra(info, x, n, k);
    }

    public static void dijkstra(List<Integer>[] info, int start, int cityCnt, int k) {
        // 각 도시별로 최단거리를 계산하기 위해서 거리 배열을 만들어야 한다.
        int[] dist = new int[cityCnt + 1];
        // 그리고 최단거리를 구할 것이기 때문에 최댓값으로 초기화한다.
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 출발하는 도시는 최단거리가 0이므로 초기화한다.
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[cityCnt + 1];

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            if (visited[curr]) continue;
            visited[curr] = true;

            for (int i  : info[curr]) {
                if (visited[i]) continue;;

                // dist[i] : start에서 i로 가는 최단거리 저장 배열
                // dist[curr] + 1 : 현재에서 거쳐 가는 거리
                if (dist[i] > dist[curr] + 1) {
                    dist[i] = dist[curr] + 1;
                    queue.add(i);
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= cityCnt; i++) {
            if (dist[i] == k) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) System.out.println(-1);
    }
}