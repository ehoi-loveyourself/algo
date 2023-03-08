package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lec90_라이언킹심바 {
    static int simbaSize = 2;
    static int time = 0;
    static int eaten = 0;
    static int simbaX, simbaY;
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정글의 크기
        map = new int[n][n];

        // 심바 위치 찾기
        simbaX = 0;
        simbaY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    simbaX = i;
                    simbaY = j;
                    map[i][j] = 0; // 심바 들어내기
                }
            }
        } // 입력 완료

        // 몸집을 키우러 가자
        bfs();

        // 시간 출력하기
        System.out.println(Arrays.deepToString(map));
        System.out.println(time);
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    // 내가 원래는 Rabbit 클래스에 거리 배열까지 넣었는데,
    // 심바의 위치가 바뀔 때마다 매번 거리를 새로 계산해줘야 하는 단점이 있어서
    // 그리고 혹시나 거기까지 가지 못할 때는 어떤 값을 반환해줘야 할지 모르겠어서
    // 강의를 봤더니 이 문제를 bfs로 푸는 거니까 한칸 이동하는게 어차피 최단 거리니까
    // 그런 식으로 큐에 담아서 이동을 해버리더라고
    // 그래서 문제 풀이 방향을 바꿈
    private static void bfs() {
        while (true) {
            // 그래도 우선순위큐를 만드는 것은 같음
            PriorityQueue<Rabbit> pq = new PriorityQueue<>();
            // 심바부터 넣고
            pq.add(new Rabbit(simbaX, simbaY, 0));

            // 방문처리도 하기
            boolean[][] visited = new boolean[n][n];
            visited[simbaX][simbaY] = true;

            while (!pq.isEmpty()) {
                Rabbit poll = pq.poll();

                // 심바보다 크기가 작으면 먹을 수 있음
                if (map[poll.x][poll.y] > 0 && map[poll.x][poll.y] < simbaSize) {
                    time += poll.cnt;
                    map[poll.x][poll.y] = 0;
                    simbaX = poll.x;
                    simbaY = poll.y;
                    eaten++;
                    if (simbaSize <= eaten) {
                        simbaSize++;
                        eaten = 0;
                    }
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = poll.x + dx[d];
                    int ny = poll.y + dy[d];

                    // 못가는 곳 : 범위를 벗어난 곳, 나보다 사이즈가 큰 토끼가 있는 곳, 방문한 적이 있는 곳
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (map[nx][ny] > simbaSize) continue;
                    if (visited[nx][ny]) continue;
                    // 이제 갈 수 있어
                    visited[nx][ny] = true;
                    pq.add(new Rabbit(nx, ny, poll.cnt + 1));
                }
            }

            // 먹을 수 있는 토끼가 없으면 브레이크
            if (allEaten()) break;
        }
    }

    // 먹을 수 있는 토끼가 없다 == 심바 사이즈보다 작은 토끼가 없다 == true
    // 전부 다 먹었거나 나보다 큰 토끼만 있어
    private static boolean allEaten() {
        boolean flag = true;
        outer :
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && map[i][j] < simbaSize) {
                    flag = false;
                    break outer;
                }
            }
        }
        return flag;
    }

    private static class Rabbit implements Comparable<Rabbit> {
        int x;
        int y;
        int cnt;

        public Rabbit(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Rabbit o) {
            if (cnt == o.cnt) {
                // x좌표가 작은 것 우선
                if (x == o.x) {
                    // y좌표가 작은 것 우선
                    return y - o.y;
                }
                return x - o.x;
            }
            return cnt - o.cnt;
        }
    }
}
