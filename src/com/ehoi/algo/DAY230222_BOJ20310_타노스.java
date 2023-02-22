package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DAY230222_BOJ20310_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3차시도
        // 아 새롭게 정렬을 하는 게 아니라 그냥 있는 문자열에서
        // 최대한 사전순에 맞게 절반을 없애는 거구나
        // 그러면 1은 앞에서부터 지우고
        // 0은 뒤에서부터 지우는 게 좋겠네
        String str = br.readLine();
        char[] arr = new char[str.length()];

        int zeroCnt = 0;
        int oneCnt = 1;
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
            if (arr[i] == '1') oneCnt++;
            else zeroCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        boolean[] cut = new boolean[str.length()];
        // 앞에서부터 1의 개수 / 2 만큼 true로 변경
        for (int i = 0; i < str.length() && oneCnt != 0; i++) {
            if (arr[i] == '1') {
                oneCnt--;
                cut[i] = true;
            }
        }
        // 뒤에서부터 0 지워
        for (int i = str.length() - 1; i >= 0 && zeroCnt != 0; i--) {
            if (arr[i] == '0') {
                zeroCnt--;
                cut[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!cut[i]) sb.append(arr[i]); // 자르지 않은 것만 붙이기
        }
        System.out.println(sb);

        /*
        String str = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1') oneCnt++;
            else zeroCnt++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < zeroCnt / 2; i++) {
            ans.append("0");
        }
        for (int i = 0; i < oneCnt / 2; i++) {
            ans.append("1");
        }
        System.out.println(ans);
         */

        /*
        String str = br.readLine();
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr);

        // 0의개수
        int zeroCnt = 0;
        for (char c : arr) {
            if (c == '0') zeroCnt++;
        }
        // 1의 개수
        int oneCnt = arr.length - zeroCnt;

        // 정렬된 순서대로 다시 문자열 만들기
        StringBuilder newStr = new StringBuilder();
        for (char c : arr) {
            newStr.append(c);
        }
        String ans = newStr.toString().substring((zeroCnt / 2), (arr.length - (oneCnt / 2)));
        System.out.println(ans);

         */
    }
}
