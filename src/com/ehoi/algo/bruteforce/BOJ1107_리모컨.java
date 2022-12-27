package com.ehoi.algo.bruteforce;

import java.util.Scanner;

public class BOJ1107_리모컨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가고자 하는 채널 입력
        int target = sc.nextInt();
        if (target == 100) {
            System.out.println(0);
            return;
        }
        // 리모컨 배열에 고장한 버튼 입력
        int num = sc.nextInt();
        boolean[] broken = new boolean[10];
        for (int i = 0; i < num; i++) {
            broken[sc.nextInt()] = true;
        }

        // 현재 채널에서 가고자 하는 채널까지 +, -만 눌러도 갈 수 있는 차를 정답으로 미리 세팅
        int ans = Math.abs(target - 100);
        // 0부터 999999까지 리모컨을 전부 눌러보면서 target 과의 차이를 검사해서 정답과 최솟값 검사
        for (int channel = 0; channel <= 999999; channel++) {
            // 채널 숫자 하나하나를 누를 수 있는지 검사
            String str = String.valueOf(channel);

            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if (broken[str.charAt(i) - '0']) { // 못 누른다면?
                    flag = true;
                    break;
                }
            }
            // 다 누를 수 있었다면? (못 누르고 나온 애는 눌리지도 않는 애니까 비교해볼 필요도 없음)
            if (!flag) {
                // 다 누른 채널의 버튼 갯수 + 채널을 위, 아래로 움직이면서 target까지 움직인 차이
                int result = str.length() + Math.abs(channel - target);
                ans = Math.min(result, ans); // 결과와 정답 최솟값 비교
            }
        }
        // 정답 출력
        System.out.println(ans);
        sc.close();
    }
}
// 0에서 -를 눌러도 최대 채널로 가지 않는다. 그대로 0이다.
// 수빈이의 지금 채널은 100번
// 채널 N으로 이동하기 위해 최소 몇 번을 눌러야 하는지 => 구하고자 하는 바

/**
 * [깨달은 것]
 * 1. 수빈이가 이동하려고 하는 채널은 최대 500,000이므로
 * 리모컨으로 누를 수 있는 최대 범위는 999,999로 설정해야 한다.
 *
 * 2. 최대한 근접한 채널로 갈 방법을 생각해보려고 했으나,
 * 제한시간이 2초이고 이중 반복문이 없는 것을 고려해, 완탐으로 풀면 된다.
 */
