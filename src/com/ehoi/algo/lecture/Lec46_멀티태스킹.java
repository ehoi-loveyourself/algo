package com.ehoi.algo.lecture;

import java.util.*;

public class Lec46_멀티태스킹 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 작업 개수
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }
        int second = sc.nextInt(); // 정전이 발생한 시간

        int bp = 0;
        int pos = 0;
        int answer = 0;
        while (true) {
            if (tasks[pos] != 0) { // 작업이 덜 끝났다면
                tasks[pos]--; // 작업을 해주자
                bp++; // 1초 지남
            }
            pos++; // 자리 이동
            if (pos == n) pos = 0; // 범위를 벗어났다면 다시 0으로 이동
            if (bp == second) { // 정전이 났다면
                while (tasks[pos] == 0) pos++; // 작업이 이미 끝난 거라면 작업이 안 끝난 거 찾아
                answer = pos + 1;
                break;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
