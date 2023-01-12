package com.ehoi.algo.lecture;

import java.util.Scanner;

/**
 * 강의 내용을 간략히 작성해보자면
 * 15 = * + * : 두 수의 합으로 가능한지 보려면
 * 1 + 2 의 합인 3을 15에서 뺀다
 * 12는 2로 나뉘어 떨어진다
 * 그 몫을 1과 2에 더한다
 * 15 = (1 + 6) + (2 + 6) = 7 + 8
 *
 * 15 = * + * + * : 세 수의 합으로 가능한지 보려면
 * 1 + 2 + 3 의 합은 6을 15에서 뺀다
 * 9는 3으로 나뉘어 떨어진다
 * 그 몫을 1, 2, 3에 더한다
 * 15 = (1 + 3) + (2 + 3) + (3 + 3) = 4 + 5 + 6
 *
 * 15 = * + * + * + * : 네 수의 합으로 가능한지 보려면
 * 1 + 2 + 3 + 4의 합인 10을 15에서 뺀다
 * 5는 4으로 나뉘어 떨어지지 않는다 bye
 *
 * 15 = * + * + * + * + * : 다섯 수의 합으로 가능한지 보려면
 * 1 + 2 + 3 + 4 + 5의 합인 15을 15에서 뺀다
 * 0는 5으로 나눈 나머지가 0이므로
 * 그 몫을 1, 2, 3, 4, 5에 더한다
 * 15 = (1 + 0) + (2 + 0) + (3 + 0) + (4 + 0) + (5 + 0) = 1 + 2 + 3 + 4 + 5
 */
public class Lec41_연속된자연수의합_강의버전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 2; i < n; i++) {
            int tmp = n;
            for (int j = 1; j <= i; j++) {
                tmp -= j;
            }
            if (tmp >= 0 && tmp % i == 0) {
                cnt++;
                int k = tmp / i;
                System.out.printf("%d ", 1 + k);
                for (int j = 2; j <= i; j++) {
                    System.out.printf("+ %d ", j + k);
                }
                System.out.print("= 15\n");
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
