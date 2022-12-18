package com.ehoi.algo.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6588_골드바흐의추측 {
    private static final int MAX = 1_000_000;
    private static final boolean[] isNotPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // false가 소수 ! 소수가 아닌 것을 true로 바꾸기
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < isNotPrime.length; i++) {
            // 소수 중에 소수가 아닌 것 판별
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < isNotPrime.length; j += i) {
                    isNotPrime[i] = true; // 소수 아님!
                }
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            if (solve(num)) continue;
            System.out.println("Goldbach's conjecture is wrong.");
            break;
        }
        br.close();
    }

    private static boolean solve(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[num - i]) {
                System.out.printf("%d = %d + %d\n", num, i, num - i);
                return true;
            }
//            if (isPrime(i)) {
//                int rest = num - i;
//                if (isPrime(rest)) {
//                    System.out.printf("%d = %d + %d\n", num, i, rest);
//                    return true;
//                }
//            }
        }
        return false;
    }

//    private static boolean isPrime(int num) {
//        boolean flag = true;
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }
}
