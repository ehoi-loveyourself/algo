package com.ehoi.algo.bruteforce;

import java.util.*;

public class BOJ1759_암호만들기 {
    static int l, c;
    static char[] alphabet, ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        alphabet = new char[c];
        ans = new char[l];
        visited = new boolean[c];

        for (int i = 0; i < c; i++) {
            alphabet[i] = sc.next().charAt(0);
        }
        // 오름차순으로 정렬
        Arrays.sort(alphabet);

        recur(0, 0);
        System.out.println(sb);
        sc.close();
    }

    private static void recur(int start, int cnt) {
        System.out.println("start : " + start);
        System.out.println("cnt : " + cnt);
        if (cnt == l) {
            if (check(ans)) {
                for (char c : ans) {
                    sb.append(c);
                }
                sb.append("\n");
                // return; // 리턴의 위치가 여기면 안됨!!
            }
            return;
        }

        for (int i = start; i < c; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[cnt] = alphabet[i];
            recur(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    private static boolean check(char[] arr) {
        int mo = 0;
        int ja = 0;
        String moeum = "aeiou";
        for (char c : arr) {
            if (moeum.contains(String.valueOf(c))) {
                mo++;
            } else {
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}
