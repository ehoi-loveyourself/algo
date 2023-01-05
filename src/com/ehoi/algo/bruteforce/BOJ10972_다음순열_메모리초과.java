package com.ehoi.algo.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10972_다음순열_메모리초과 {
    static int n;
    static boolean[] visited;
    static int[] sel;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        sel = new int[n];

        String input = br.readLine().trim();

        perm(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).trim().equals(input)) {
                if (i == list.size() - 1) System.out.println(-1);
                else System.out.println(list.get(i + 1));
            }
        }
        br.close();
    }

    private static void perm(int cnt) {
        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : sel) {
                sb.append(i).append(" ");
            }
            list.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
