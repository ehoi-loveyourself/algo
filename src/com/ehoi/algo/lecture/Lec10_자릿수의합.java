package com.ehoi.algo.lecture;

import java.util.*;

public class Lec10_자릿수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int ans = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int sum = digit_num(num); // 자리수의 합을 구하고
            if (sum > max) {
                max = sum;
                ans = num;
            } else if (sum == max) {
                if (num > ans) {
                    ans = num;
                }
            }
        }

        System.out.println(ans);
    }

    private static int digit_num(int x) {
        int sum = 0;
//        while (true) {
//            if (x < 10) {
//                sum += x;
//                break;
//            }
//            sum += x % 10;
//            x /= 10;
//        }
        // 훨씬 더 간결한.. 그리고 더 가독성도 좋은!
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
