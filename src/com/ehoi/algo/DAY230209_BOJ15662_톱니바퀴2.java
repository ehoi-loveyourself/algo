package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230209_BOJ15662_톱니바퀴2 {
    static int[][] wheels;
    static boolean[] visited;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken()); // 톱니바퀴 개수
        wheels = new int[t][8];
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = str.charAt(j) - '0';
            }
        }

        int commands = Integer.parseInt(br.readLine());
        for (int i = 0; i < commands; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            // 명령 하나 보낼따마다 방문배열 초기화
            visited = new boolean[t];
            comm(row, direction);
        }

        // 12시 방향이 S극인 톱니바퀴 개수 세기
        int cnt = 0;
        for (int i = 0; i < t; i++) {
            if (wheels[i][0] == 1) cnt++;
        }

        System.out.println(cnt);
    }

    private static void comm(int row, int direction) {
        // 현재 들어온 row의 톱니바퀴는 회전시킬 거니까 방문처리
        visited[row] = true;

        // 내 위랑 아래에 톱니바퀴가 있는지, 있다면 나랑 인접한 톱니바퀴가 서로 다른 극인지, 다른 극이라면 걔네도 회전
        int[] arr = {-1, 1};
        for (int i = 0; i < 2; i++) {
            // 인접한 톱니바퀴의 row
            int adjRow = row + arr[i];
            // 인접한 톱니바퀴가 있는지 확인
            if (adjRow < 0 || adjRow >= t) continue;
            // 그 톱니바퀴 회전한 적 있는지 확인
            if (visited[adjRow]) continue;
            // 위쪽 열을 검사하고 있다면
            if (arr[i] == -1) {
                // 서로 다른 극이라면
                if (wheels[row][6] != wheels[adjRow][2]) {
                    // 그 인접한 톱니바퀴는 반대방향으로 도는 거야
                    comm(adjRow, direction * -1);
                }
            } else {
                if (wheels[row][2] != wheels[adjRow][6]) {
                    comm(adjRow, direction * -1);
                }
            }
        }

        // 그리고 나도 회전하는 거야
        rotate(row, direction);
    }

    private static void rotate(int row, int direction) {
        if (direction == -1) {
            int tmp = wheels[row][0];
            for (int i = 1; i <= 7; i++) {
                wheels[row][i - 1] = wheels[row][i];
            }
            wheels[row][7] = tmp;
        } else {
            int tmp = wheels[row][7];
            for (int i = 6; i >= 0; i--) {
                wheels[row][i + 1] = wheels[row][i];
            }
            wheels[row][0] = tmp;
        }
    }
}
