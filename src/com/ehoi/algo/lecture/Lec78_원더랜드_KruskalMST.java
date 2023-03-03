package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 유니언파인드를 활용하는 알고리즘
// 최소 스패닝 트리 이므로 모든 노드를 잇기만 하면 된다. 그래서 간선의 수가 노드 - 1개이다.
public class Lec78_원더랜드_KruskalMST {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 노드 수
        int e = Integer.parseInt(st.nextToken()); // 간선 수

        // 정점의 부모배열
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 정보를 입력하고
        int[][] graph = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 간선의 비용을 오름차순으로 정렬 : 이게 핵심!!!!
        Arrays.sort(graph, (o1, o2) -> {
           return o1[2] - o2[2];
        });

        // 디버깅
//        System.out.println(Arrays.deepToString(graph));

        // 간선을 앞에서부터 보면서 조건에 맞는 정점 연결
        int ans = 0;
        for (int i = 0; i < e; i++) {
            // 정점 두개의 부모가 서로 다르다면
            int a = graph[i][0];
            int b = graph[i][1];
            if (find(a) != find(b)) {
                // 둘을 합치고
                union(a, b);
                ans += graph[i][2];
            }
            // 서로 같으면 걍 skip
        }

        System.out.println(ans);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        // 부모를 찾자
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
