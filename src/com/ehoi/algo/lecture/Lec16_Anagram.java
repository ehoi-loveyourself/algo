package com.ehoi.algo.lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec16_Anagram {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[] a = sc.next().toCharArray();
//        Arrays.sort(a);
//        char[] b = sc.next().toCharArray();
//        Arrays.sort(b);
//
//        String ans = "YES";
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != b[i]) {
//                ans = "NO";
//            }
//        }
//        System.out.println(ans);
//    }

    // sort 함수를 쓰지 않고 구현하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[53];
        int[] b = new int[53];

        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 대문자면 -64
            // 소문자면 97 -> 27 : -70
            if ('A' <= c && c <= 'Z') a[c - 64]++;
            else a[c - 70]++;
        }
        str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 대문자면 -64
            // 소문자면 97 -> 27 : -70
            if ('A' <= c && c <= 'Z') b[c - 64]++;
            else b[c - 70]++;
        }

        String ans = "YES";
        for (int i = 1; i <= 52; i++) {
            if (a[i] != b[i]) {
                ans = "NO";
                break;
            }
        }
        System.out.println(ans);
    }
}
