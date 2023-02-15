package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAY230215_BOJ67409_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 컨베이어 한쪽의 길이
        int k = Integer.parseInt(st.nextToken()); // 내구도 기준

        st = new StringTokenizer(br.readLine());
        Belt[] belt = new Belt[2 * n];
        for (int i = 0; i < belt.length; i++) {
            int p = Integer.parseInt(st.nextToken());
            belt[i] = new Belt(p, false); // 내구도와 처음엔 로봇이 없으니까 false를 넣는다.
        }

        int stage = 0;
        while (true) {
            stage++;
            // 1. 컨베이어 벨트를 회전시킨다
            move(belt);
            // 로봇 내리기
            check(belt, n - 1);
            // 2. 벨트에 올라탄 로봇 중에 이동할 수 있다면 이동시킨다.
            for (int i = n - 2; i >= 0; i--) {
                // 벨트에 로봇이 없다면
                if (!belt[i].robot) continue;
                // 그 다음 칸에 로봇이 있다면
                if (belt[i + 1].robot) continue;
                // 그 다음 칸에 내구도가 0이라면
                if (belt[i + 1].power == 0) continue;
                // 이젠 다음 칸으로 이동할 수 있어
                belt[i + 1].robot = true;
                belt[i].robot = false;
                belt[i + 1].power--;
            }
            // 로봇 내리기
            check(belt, n - 1);
            // 3. 올리는 위치에 내구도가 0이 아니면 로봇을 올린다.
            if (belt[0].power != 0) {
                belt[0].robot = true;
                belt[0].power--;
            }
            // 4. 내구도가 0인 칸을 확인하고 K 이상이라면 종료 한다.
            int cnt = 0;
            for (Belt b : belt) {
                if (b.power == 0) cnt++;
            }
            if (cnt >= k) break;
        }

        System.out.println(stage);
    }

    private static void check(Belt[] belt, int last) {
        // 마지막 벨트에 로봇이 있으면 내린다
        if (belt[last].robot) {
            belt[last].robot = false;
        }
    }

    private static void move(Belt[] belt) {
        Belt tmp = belt[belt.length - 1]; // 마지막꺼 옮겨놓고
        for (int i = belt.length - 2; i >= 0; i--) {
            belt[i + 1] = belt[i];
        }
        belt[0] = tmp;
    }

    private static class Belt {
        int power;
        boolean robot;

        public Belt(int power, boolean robot) {
            this.power = power;
            this.robot = robot;
        }
    }
}

/*
아무 로봇 없이 벨트를 먼저 회전시키고 로봇을 처음 올리는 게 정답 처리가 됩니다.
로봇을 올리고 벨트를 회전시키면 두 번째 예시 케이스에서 30이 나옵니다

'1.' 과정에서 컨베이어벨트가 한 칸 회전 할 때, 컨베이어 벨트 위에 있던 로봇들도 같이 한 칸 움직여요.
그리고 그것과 별개로 '2.' 과정에서 로봇들이 또 한 칸 움직입니다.
 */
