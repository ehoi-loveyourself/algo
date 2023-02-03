package com.ehoi.algo;

import java.util.*;

public class DAY230203_PRO_소수찾기 {
    static int answer, n;
    static String numbers;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        this.numbers = numbers;
        n = numbers.length();
        visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            // i개까지 고를 수 있음
            recur(0, i, "");
        }

        while (set.iterator().hasNext()) {
            int res = set.iterator().next();
            System.out.println(res);
            set.remove(res);

            if (isPrime(res)) answer++;
        }

        return answer;
    }

    private static void recur(int cnt, int max, String str) {
        // 다 골랐으면
        if (cnt == max) {
            // str -> int로 해서 set에 넣기
            int res = Integer.parseInt(str);
            set.add(res);
            return;
        }

        // 중복은 안되게 순열로 골라야 함
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(cnt + 1, max, str + numbers.charAt(i));
            visited[i] = false;
        }
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        boolean flag = true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}