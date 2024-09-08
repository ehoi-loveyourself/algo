package com.ehoi.algo.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20055_컨베이어벨트위의로봇 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Belt[] belts = new Belt[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int p = Integer.parseInt(st.nextToken());
            belts[i] = new Belt(false, p);
        }

        int stage = 0;

        // 벨트는 계속 돈다. 내구도의 조건이 완성될때까지
        while (true) {
            // 단계 올리기
            stage++;

            // 벨트 회전 시키기
            move(belts);

            // 로봇 내리기
            down(belts);

            // 로봇 이동시키기
            moveRobot(belts);

            // 로봇 내리기
            down(belts);

            // 로봇 올리기
            up(belts);

            // 내구도 조건 확인
            int cnt = 0;
            for (int i = 0; i < belts.length; i++) {
                if (belts[i].power == 0) {
                    cnt++;
                }
            }
            if (cnt >= k) break;
        }

        System.out.println(stage);
    }

    private static void up(Belt[] belts) {
        if (belts[0].power == 0) return;
        belts[0].power--;
        belts[0].robot = true;
    }

    private static void moveRobot(Belt[] belts) {
        for (int i = belts.length / 2 - 2; i >= 0; i--) {
            // 해당 칸에 로봇이 없으면 패스
            if (!belts[i].robot) continue;
            // 다음 칸에 로봇이 있으면 패스
            if (belts[i + 1].robot) continue;
            // 다음 칸에 내구도가 0이면 패스
            if (belts[i + 1].power == 0) continue;
            // 이동할 수 있는 상태
            belts[i].robot = false;
            belts[i + 1].robot = true;
            belts[i + 1].power--;
        }
    }

    private static void move(Belt[] belts) {
        Belt tmp = belts[belts.length - 1];
        for (int i = belts.length - 2; i >= 0; i--) {
            belts[i + 1] = belts[i];
        }
        belts[0] = tmp;
    }

    private static void down(Belt[] belts) {
        // n-1 번째 자리에 로봇이 있으면 내려주기
        if (belts[n - 1].robot) {
            belts[n - 1].robot = false;
        }
    }

    private static class Belt {
        private boolean robot;
        private int power;

        public Belt(boolean robot, int power) {
            this.robot = robot;
            this.power = power;
        }
    }
}