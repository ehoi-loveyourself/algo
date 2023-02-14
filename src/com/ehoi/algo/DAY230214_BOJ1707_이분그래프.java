package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DAY230214_BOJ1707_이분그래프 {
    static List<Integer>[] adj;
    static int v;

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

            bfs();
        }
    }

    // 문제에서는 이분 그래프를 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때 라고 설명했지만
    // 조금 더 쉽게 이야기 하면 나와 인접한 정점에 있는 정점이 나와 다른 색? 값? 종족 이어야 한다는 것을 말한다.
    // 그래서 큐에 맨 처음 집어 넣는 것을 1이라고 친다면
    // 그 정점과 연결된 다른 정점들은 2여야 하고 값이 2인 정점들은 1인 정점과 연결 되어 있어야 하고 그런 것이다.
    // 즉, 연결된 정점을 확인했는데, 나와 값이 같다면? 그것은 이분 그래프가 아니므로 NO를 뱉으면 된다.
    /*
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[v + 1]; // 1, 2 값을 넣을 배열

        // 처음에는 이런 식으로 코드를 짰다.
        visit[1] = 1;
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int j = 0; j < adj[now].size(); j++) {
                if(visit[adj[now].get(j)] == 0) {
                    // 하지만 여기서 연결되어 있는 애들만 큐에 넣다보니까 이 애들을 다 꺼내고 나면
                    // 아직 방문하지 않은 정점이 있음에도 불구하고 큐가 비어버린다.
                    q.add(adj[now].get(j));
                }

                if(visit[adj[now].get(j)] == visit[now]) {
                    System.out.println("NO");
                    return;
                }

                if(visit[now] == 1 && visit[adj[now].get(j)] == 0)
                    visit[adj[now].get(j)] = 2;
                else if(visit[now] == 2 && visit[adj[now].get(j)] == 0)
                    visit[adj[now].get(j)] = 1;
            }
        }
        System.out.println("YES");
    }
     */

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[v + 1]; // 1, 2 값을 넣을 배열

        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                q.add(i);
            }

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int j = 0; j < adj[curr].size(); j++) {
                    int next = adj[curr].get(j); // 연결된 비교 대상을 꺼내고

                    // 얘가 기준과 같다면 틀린거야
                    if (next == visited[curr]) {
                        System.out.println("NO");
                        return;
                    }

                    if (visited[next] == 0) {
                        // 방문 안한거니까 큐에 집어넣어
                        q.add(next);
                        // 서로 다른 값으로 집어넣기
                        if (visited[curr] == 1) {
                            visited[next] = 2;
                        } else if (curr == 2) {
                            visited[next] = 1;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
