package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230220_BOJ19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 총 원소 수
        int k = Integer.parseInt(st.nextToken()); // 최대 거리 수

        char[] arr = new char[n];
        String tmp = br.readLine();
        List<Integer> person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = tmp.charAt(i);
            if (arr[i] == 'P') person.add(i);
        }

        boolean[] eaten = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'H') continue; // 햄버거라면 넘기고
            // 사람이라면
            for (int j = i - k; j <= i + k; j++) {
                // 햄버거를 찾는다
                if (j < 0 || j >= n) continue; // 범위 안에 있고
                if (arr[j] == 'P') continue; // 햄버거라면
                if (eaten[j]) continue; // 먹지 않았다면
                eaten[j] = true; // 내가 먹어버리고
                ans++;
                break;
            }
        }
        System.out.println(ans);
    }
}
