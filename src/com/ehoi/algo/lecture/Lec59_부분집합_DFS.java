package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec59_부분집합_DFS {
    static boolean[] visited;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        dfs(1);
        sc.close();
    }

    private static void dfs(int num) {
        if (num == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) System.out.printf("%d ", i);
            }
            System.out.println();
            return;
        }

        // 담고 가고 빼고 가고
        visited[num] = true;
        dfs(num + 1);
        visited[num] = false;
        dfs(num + 1);
    }
}
