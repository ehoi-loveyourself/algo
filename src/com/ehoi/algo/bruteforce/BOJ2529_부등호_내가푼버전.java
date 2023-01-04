package com.ehoi.algo.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ2529_부등호_내가푼버전 {
    static int k;
    static char[] arr;
    static boolean[] visited = new boolean[10];
    static int[] sel;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 다 받고 배열들 초기화 하기
        k = Integer.parseInt(st.nextToken());
        arr = new char[k];
        sel = new int[k + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        // 숫자 골라오게 메서드 던지기
        recur(0);

        // 출력할 때, min이랑 max String으로 바꾸고 둘다 길이가 K + 1 안되면 맨앞에 0 붙여서 출력하기
        String str_max = String.valueOf(max);
        String str_min = String.valueOf(min);
        System.out.println(str_max.length() != k + 1 ? "0" + str_max : str_max);
        System.out.println(str_min.length() != k + 1 ? "0" + str_min : str_min);
    }

    // 중복없이 순열르 정수 10개 중에 k + 1개 골라오는 재귀 만들기
    // base : cnt == k + 1 이면, 부등호랑 부합하는지 확인하는 메서드 던지기
    // 부합하면 sel 배열을 다 숫자로 옮겨서 최대값, 최솟값 갱신
    private static void recur(int cnt) {
        if (cnt == k + 1) {
            if (check()) {
                StringBuilder tmp = new StringBuilder();
                for (int i : sel) {
                    tmp.append(i);
                }
                max = Math.max(max, Long.parseLong(tmp.toString())); // 숫자가 10자리면 정수 범위를 넘어서는 것을 생각 못했네!!!
                min = Math.min(min, Long.parseLong(tmp.toString()));
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[cnt] = i;
            recur(cnt + 1);
            visited[i] = false;
        }
    }

    // 부등호랑 맞는지 체크하는 메서드
    private static boolean check() {
        boolean flag = true;
        for (int i = 0; i < sel.length - 1; i++) {
            if ((arr[i] == '<' && sel[i] > sel[i + 1]) || (arr[i] == '>' && sel[i] < sel[i + 1])) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
