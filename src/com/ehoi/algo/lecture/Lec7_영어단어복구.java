package com.ehoi.algo.lecture;

import java.util.*;

public class Lec7_영어단어복구 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String str = sc.nextLine();
//        str = str.replace(" ", "").toLowerCase();
//        System.out.println(str);

        char[] word = sc.nextLine().toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            // 공백이면 바이
            if (c == ' ') continue;
            // 대문자면 소문자로 바꿔서 넣고
            if ('A' <= c && c <= 'Z') ans.append((char)(c + ('a' - 'A')));
            // 소문자면 그냥 넣고
            else ans.append(c);
        }
        System.out.println(ans);
    }
}
