package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec60_합이같은부분집합_DFS {
    static int n, sum;
    static int[] nums;
    static boolean[] visited;
    static String ans = "NO";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        dfs(0);
        System.out.println(ans);
        sc.close();
    }

    private static void dfs(int num) {
        if (num == n) {
            // true인 애들만 합을 구해보자
            // sum 에서 뺀 것과 같으면 yes를 출력하자
            // 근데 앞에서 true가 나오면 그냥 이 재귀 자체를 그만두게 할 수는 없나?
            int trueSum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) trueSum += nums[i];
            }
            if (trueSum == sum - trueSum) ans = "YES";
            return;
        }
        // 뽑고 가고 안 뽑고 가고
        visited[num] = true;
        dfs(num + 1);
        visited[num] = false;
        dfs(num + 1);
    }
}
