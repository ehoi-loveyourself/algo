package com.ehoi.algo.greedy;

import java.io.IOException;
import java.util.Scanner;

public class BOJ12934_턴게임 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // int가 아니라 long이 들어올 수 있다.
        long x = sc.nextLong();
        long y = sc.nextLong();

        // 두 점수의 합을 봤을 때, 1, 2, 3, ... , n까지의 합이 가능한지 확인한다.
        long sum = x + y;
        long turn = 1;

        while (true) {
            long totalScore = turn * (turn + 1) / 2;
            if (totalScore == sum) {
                break;
            } else if (totalScore < sum) {
                turn++;
            } else { // 불가능
                System.out.println(-1);
                return;
            }
        }

        // 가능한 지점에만 여기까지 내려온다.
        // 이제 최소로 이길 수 있는 턴 수를 구해야 한다.
        // 지금까지 총 turn 만큼 경기를 했다.
        // 그 중에 윤호가 이긴 점수는 x이다.
        // x에서 turn 을 계속 빼나가다가 x가 0 이하로 떨어지는 시점이 되면 turn 을 뺀 횟수만큼이
        // 윤효가 최소로 이긴 경기 수가 된다.
        long cnt = 0;
        while (x > 0) {
            x -= turn--;
            cnt++;
        }
        System.out.println(cnt);
    }
}