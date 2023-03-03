package com.ehoi.algo.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모든 컴퓨터를 연결하는데 필요한 최소비용 : 유니온파인드를 이용한 최소스패닝트리
public class DAY230303_BOJ1922_네트워크연결 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 정점 개수
        int e = Integer.parseInt(br.readLine()); // 간선 개수

        int[][] graph = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 최소비용을 탐색합시다.
        int ans = 0;
        for (int i = 0; i < e; i++) {
            int a = graph[i][0];
            int b = graph[i][1];

            if (find(a) != find(b)) {
                union(a, b);
                ans += graph[i][2];
            }
        }

        System.out.println(ans);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
