package com.ehoi.algo.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DAY230304_BOJ1922_네트워크연결_Prim {
    static List<Computer>[] computers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 선의 수

        // 연결된 정보를 저장할 컴퓨터 배열
        computers = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            computers[i] = new ArrayList<>();
        }

        // 연결정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            computers[a].add(new Computer(b, w));
            computers[b].add(new Computer(a, w));
        }

        // 탐색을 해보자
        prim(n);
    }

    private static void prim(int n) {
        // 우선순위 큐를 초기화
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        // 이미 방문한 컴퓨터를 확인할 배열
        boolean[] visited = new boolean[n + 1];
        // 임의의 컴퓨터 아무거나 넣기
        pq.add(new Computer(1, 0));

        int ans = 0;
        while (!pq.isEmpty()) {
            Computer poll = pq.poll();

            int node = poll.node;
            int weight = poll.weight;

            // 이 컴퓨터를 방문한 적이 있습니까?
            if (visited[node]) continue;

            visited[node] = true;
            ans += weight;

            // 이 컴퓨터와 연결된 애들 중에 아직 mst로 선택되지 앟은 컴퓨터를 넣으세요
            for (Computer c : computers[node]) {
                if (!visited[c.node]) {
                    pq.add(c);
                }
            }
        }
        System.out.println(ans);
    }

    private static class Computer implements Comparable<Computer> {
        private int node;
        private int weight;

        public Computer(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Computer o) {
            return this.weight - o.weight;
        }
    }
}
