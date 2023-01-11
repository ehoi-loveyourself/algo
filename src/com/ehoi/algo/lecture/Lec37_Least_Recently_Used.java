package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec37_Least_Recently_Used {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cache = new int[n]; // 캐시

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int task = sc.nextInt();
            int check = existsTask(task, cache);
            if (check == -1) { // 없다면
                for (int j = n - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
            } else { // 있다면
                for (int j = check - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
            }
            cache[0] = task;
        }

        for (int i : cache) {
            System.out.printf("%d ", i);
        }

        sc.close();
    }

    private static int existsTask(int task, int[] cache) {
        for (int i = 0; i < cache.length; i++) {
            if (task == cache[i]) return i;
        }
        return -1;
    }
}
