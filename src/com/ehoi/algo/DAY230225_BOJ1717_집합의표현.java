package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230225_BOJ1717_집합의표현 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i; // 자기 부모를 자기 자신으로 설정
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (comm == 0) {
                union(x, y);
            } else {
                System.out.println(find(x) == find(y) ? "YES" : "NO");
            }
        }
    }

    private static void union(int x, int y) {
        // x와 y의 부모를 찾는다.
        x = find(x);
        y = find(y);

        if (x < y) {
            // x를 y의 부모로 만든다.
            p[y] = x;
        } else {
            p[x] = y;
        }
    }

    private static int find(int x) {
        if (p[x] == x) return x;

//        return find(p[x]); // 이렇게 하면 매번 계속 찾으러 재귀를 가야해서 아래처럼 갱신을 해둡시다!
        return p[x] = find(p[x]);
    }
}
