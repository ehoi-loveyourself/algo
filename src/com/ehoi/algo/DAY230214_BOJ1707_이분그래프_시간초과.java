package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230214_BOJ1707_이분그래프_시간초과 {
    static List<Integer>[] adj;
    static int v;
    static boolean ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken()); // 정점 수
            int e = Integer.parseInt(st.nextToken()); // 간선 수

            adj = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                adj[i] = new ArrayList<>(); // 초기화 해주기
            }

            for (int i = 0; i < e; i++) { // 간선 정보 입력하기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                adj[start].add(end);
                adj[end].add(start);
            }

            boolean flag = true;
            // 정점을 둘로 분할
            for (int i = 1; i <= v / 2; i++) {
                boolean[] visited = new boolean[v + 1];
                ans = true;
                divide(0, 0, i, visited); // i개 고르면 돼
            }

            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void divide(int start, int cnt, int max, boolean[] visited) {
        if (cnt == max) {
            // 다 골랐다면 방문한 것과 방문하지 않은 것 둘다 보면서
            // 같은 집합안에 있는 원소끼리 연결되어 있으면 NO 아니어야 YES
            boolean flag = true; // 서로 인접하지 않을거야
            if (check(visited)) { // 인접하면
                flag = false;
            }

            ans = flag; // 인접하지 않으면 true
        }

        for (int i = start; i <= v; i++) {
            // 이미 골랐다면 패스
            if (visited[i]) continue;
            visited[i] = true;
            divide(i + 1, cnt + 1, max, visited);
            visited[i] = false;
        }
    }

    private static boolean check(boolean[] visited) {
        boolean flag = false; // 인접하지 않겠지

        List<Integer>[] list = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < visited.length; i++) {
            // 방문 한 것들 중에서 확인을 해봐야 하늬까
            if (visited[i]) list[0].add(i);
            else list[1].add(i);
        }

        outer:
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < list[k].size() - 1; i++) {
                for (int j = i + 1; j < list[k].size(); j++) {
                    int curr = list[k].get(i); // 기준
                    int next = list[k].get(j); // 비교 대상

                    // 둘 사이에 연결점이 있으면?
                    if (adj[curr].contains(next)) {
                        flag = true;
                        break outer;
                    }
                }
            }
        }

        return flag;
    }
}
