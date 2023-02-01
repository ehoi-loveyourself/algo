package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DAY230201_BOJ2667_단지번호붙이기 {
    static int n, cnt;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
            }
        } // 입력 완료

        cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    int num = bfs(i, j); // 한 단지를 탐색하고 나오면
                    list.add(num);
                    cnt++; // 그 단지 수 추가
                }
            }
        }

        System.out.println(Arrays.deepToString(graph));
        Collections.sort(list);
        System.out.println(cnt);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static int bfs(int r, int c) {
        // 리턴할 빌딩 개수
        int building = 0;
        // 단지 첫 건물 들어왔으니까 방문했다는 뜻으로 2로 만들자
        graph[r][c] = 2;
        building++;

        // 해당 건물부터 큐에 넣어서 4방탐색 해야 하니까 큐를 만들자
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10 * r + c);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            int x = curr / 10; // 현재 행
            int y = curr % 10; // 현재 열

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d]; // 새로운 좌표
                int ny = y + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                // 단지가 아니거나 이미 방문한 집이면 패스
                if(graph[nx][ny] == 0 || graph[nx][ny] == 2) continue;
                // 여기까지 오면 방문가능한 집 -> 방문처리 해주기
                graph[nx][ny] = 2;
                queue.add(nx * 10 + ny);
                building++;
            }
        }
        return building;
    }
}
