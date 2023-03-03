package com.ehoi.algo.mst;

import java.io.*;
import java.util.*;

public class DAY230303_BOJ1197_최소스패닝트리 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 정점 개수
        int e = Integer.parseInt(st.nextToken()); // 간선 개수

        int[][] graph = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        // 탐색 시작
        // 필요한 것들부터 만들고
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < e; i++) {
            int a = graph[i][0];
            int b = graph[i][1];

            // 둘의 부모가 다르면
            if (find(a) != find(b)) {
                union(a, b); // 합치고 => 같은 종족으로 만든다 => 선택한다
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
        // 둘의 부모를 찾아서
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
