package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230206_BOJ1593_문자해독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wLen = Integer.parseInt(st.nextToken());
        int sLen = Integer.parseInt(st.nextToken());
        String w = br.readLine();
        String s = br.readLine();
        // 입력 끝

        // 대문자와 소문자를 넣을 배열 두개를 만든다
        int[] wArr = new int[52];
        int[] sArr = new int[52];

        // w 문자열을 채운다
        for (char c : w.toCharArray()) {
            inputChar(c, wArr, 1);
        }

        // 이제 s 문자열을 배열에 wLen만큼 채우면서 두 배열이 같은지 비교할 것이다.
        int ans = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            inputChar(c, sArr, 1);
            size++;

            if (size == wLen) {
                if (Arrays.equals(wArr, sArr)) ans++;

                // 이제 맨 앞에 들어왔던 문자는 다시 빼준다
                inputChar(s.charAt(i - wLen + 1), sArr, -1);
                size--;
            }
        }
        System.out.println(ans);
    }

    private static void inputChar(char c, int[] arr, int num) {
        // 소문자 대문자 구분
        if ('a' <= c && c <= 'z') {
            arr[c - 'a'] += num; // 이 num을 그대로 반영하는 게 아니라 더해주고 빼주고 할 것이다.
        } else {
            arr[c - 'A' + 26] += num;
        }
    }
}
