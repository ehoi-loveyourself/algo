package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec84_휴가_DFS {
    private static int max, n;
    private static int[][] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine()); // n일 동안 일할 수 있다
        arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());        } // 입력 완료

        visited = new boolean[n + 1];
        dfs(1, 0, "");
        System.out.println(max);
    }

    private static void dfs(int day, int sum, String str) {
        if (day == n + 1) { // 딱 n + 1일이 되어야 휴가르 ㄹ떠날 수 있어
            if (max < sum) {
                max = sum;
                System.out.println(str);
            }
            return;
        }

        // 일을 한다
        if (day + arr[day][0] <= n + 1) { // 이 날안에 끝날 수 있어야해
            dfs(day + arr[day][0], sum + arr[day][1], str + day + " ");
        }
        // 일을 안한다
        dfs(day + 1, sum, str);
    }
}
