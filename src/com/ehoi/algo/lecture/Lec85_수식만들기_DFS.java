package com.ehoi.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lec85_수식만들기_DFS {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[] arr, op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수의 개수

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        // + - * /
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
           op[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int res) {
        if (idx == n) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

//        for (int i = 0; i < op.length; i++) {
//            if (op[i] == 0) continue; // 쓸 게 없으면 패스
//            op[i]--;
//            dfs(idx + 1, cal(i, res, idx));
//            op[i]++;
//        }

        if (op[0] > 0) {
            op[0]--;
            dfs(idx + 1, res + arr[idx]);
            op[0]++;
        }
        if (op[1] > 0) {
            op[1]--;
            dfs(idx + 1, res - arr[idx]);
            op[1]++;
        }
        if (op[2] > 0) {
            op[2]--;
            dfs(idx + 1, res * arr[idx]);
            op[2]++;
        }
        if (op[3] > 0) {
            op[3]--;
            dfs(idx + 1, res / arr[idx]);
            op[3]++;
        }
    }

    private static int cal(int i, int res, int idx) {
        if (i == 0) {
            // 덧셈
            return res + arr[idx];
        } else if (i == 1) {
            // 빼기
            return res - arr[idx];
        } else if (i == 2) {
            // 곱셈
            return res * arr[idx];
        } else {
            return res / arr[idx];
        }
    }
}
