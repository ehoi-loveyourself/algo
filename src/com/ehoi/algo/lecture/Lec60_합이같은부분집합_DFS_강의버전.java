package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec60_합이같은부분집합_DFS_강의버전 {
    static int n, total;
    static int[] nums;
    static String ans = "NO";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            total += nums[i];
        }
        dfs(0, 0);
        System.out.println(ans);
        sc.close();
    }

    private static void dfs(int k, int sum) {
        if (ans.equals("YES")) return; // 백트래킹! : 재귀가 넘어올 때마다 이미 정답이 YES라면 볼 필요 없으니까 빠르게 return!
        if (sum > (total / 2)) return; // 백트래킹 2번째! : 지금까지 넘어온 합이 전체 합의 반을 이미 넘어섰다? 그러면 가망이 없으니 return!
        if (k == n) {
            if (total - sum == sum) ans = "YES";
            return;
        }
        dfs(k + 1, sum + nums[k]); // 뽑고 가고
        dfs(k + 1, sum); // 안 뽑고 가고
    }
}
