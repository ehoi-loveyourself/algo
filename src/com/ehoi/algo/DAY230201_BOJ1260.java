package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DAY230201_BOJ1260 {
    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        v = Integer.parseInt(st.nextToken()); // 시작할 정점 번호
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); // 초기화 꼭 필요
        }

        // 양방향 그래프
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e); // 양방향이니까 서로 연결해주기
            graph[e].add(s);
        }
        // 정렬을 합시다
        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);

        // 방문 배열 초기화
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(ans_dfs);
        System.out.println(ans_bfs);
        br.close();
    }

    static StringBuilder ans_dfs = new StringBuilder();
    static StringBuilder ans_bfs = new StringBuilder();

    private static void bfs(int v) {
        visited[v] = true;
        ans_bfs.append(v).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 현재 정점과 연결된 모든 정점을 꺼내서 방문 여부를 검사하고 큐에 다시 넣는다
            for (int i = 0; i < graph[curr].size(); i++) {
                int tmp = graph[curr].get(i);
                if (visited[tmp]) continue;
                visited[tmp] = true;
                ans_bfs.append(tmp).append(" ");
                queue.add(tmp);
            }
        }
    }

    private static void dfs(int v) {
        // 방문 처리
        visited[v] = true;
        ans_dfs.append(v).append(" ");

        for (int i = 0; i < graph[v].size(); i++) {
            int curr = graph[v].get(i);
            if (visited[curr]) continue;
            dfs(curr);
        }
    }

    /*
     * 반성모드 : dfs는 재귀라서 무조건 종료조건과 재귀조건으로 나뉘어야 할거라고만 생각하고
     * 그에 맞춰 구현하려고만 했다.
     * 내가 필요한 로직에 맞게 구현하려는 생각은 안하고!
    private static void dfs(int v, int cnt) {
        // 종료 조건 : 끝까지 다 갔으면 출력하기
        if (isAllVisited()) {
            System.out.println(ans_dfs);
            return;
        }

        // 재귀 조건 : 아직까지 안 가본 정점 다 돌기
        for (int i = 0; i < graph[v].size(); i++) {
            int curr = graph[v].get(i);
            if (visited[curr]) continue;
            visited[curr] = true;
            ans_dfs.append(curr).append(" ");
            dfs(curr, cnt + 1);
            visited[curr] = false;
        }
    }
     */

    private static boolean isAllVisited() {
        boolean flag = true;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
