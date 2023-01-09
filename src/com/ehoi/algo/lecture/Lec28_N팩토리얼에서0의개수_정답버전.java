package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2부터 n까지의 모든 수를 소인수분해한다.
 * 27번 문제에서는 모든 소수를 찾기 위해 배열을 사용했지만,
 * 여기서는 2와 5로 나누어떨어지는 개수만 찾으면 된다.
 * 그 이유는 소인수 중에 2와 5가 있다면 10이 되므로 0의 자리수가 생긴다.
 * 2와 5 중 최솟값 비교를 한 것이 답이 된다.
 */
public class Lec28_N팩토리얼에서0의개수_정답버전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt2 = 0;
        int cnt5 = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = i;
            int j = 2;
            while (true) {
                if (tmp % j == 0) {
                    if (j == 2) cnt2++;
                    else if (j == 5) cnt5++;
                    tmp /= j;
                } else {
                    j++;
                }
                if (tmp == 1) break;
            }
        }
        // 10의 개수를 파악해야 하는데
        int ans = Math.min(cnt2, cnt5);
        System.out.println(ans);

        sc.close();
    }
}
