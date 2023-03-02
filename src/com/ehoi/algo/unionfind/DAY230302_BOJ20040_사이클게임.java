package com.ehoi.algo.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230302_BOJ20040_사이클게임 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 점의 개수
        int m = Integer.parseInt(st.nextToken()); // 턴 수

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        } // 세팅

        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 이미 부모가 같은 것끼리 연결을 하겠다면? => 사이클이 형성된 것
            if (find(a) == find(b)) {
                ans = i + 1;
                break;
            } else {
                union(a, b);
            }
        }
        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
