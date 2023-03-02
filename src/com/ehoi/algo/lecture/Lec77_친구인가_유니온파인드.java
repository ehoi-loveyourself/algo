package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec77_친구인가_유니온파인드 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생수
        int m = Integer.parseInt(st.nextToken()); // 친구쌍 수

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i; // 자기 자신을 부모로 만들기
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            makeFriends(a, b); // 친구 만들기
        }
        st = new StringTokenizer(br.readLine());

        System.out.println(areFriends(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())) ? "YES" : "NO");
    }

    private static void makeFriends(int a, int b) {
        // a, b의 부모를 각각 찾아서 하나의 부모로 엮어주는 거야
        a = find(a);
        b = find(b);

        if (a < b) {
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    private static int find(int a) {
        // 내 부모가 나면 나를 리턴
        if (p[a] == a) return a;
        // 최종 부모를 나에게 메모이제이
        return p[a] = find(p[a]);
    }

    private static boolean areFriends(int a, int b) {
        return find(a) == find(b);
    }
}
