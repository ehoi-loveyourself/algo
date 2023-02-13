package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAY230213_BOJ4659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String pw = br.readLine();
            if (pw.equals("end")) break;

            boolean flag = true;
            // 모음을 반드시 하나 포함하지 않는다면 false
            if (!includeVowel(pw)) flag = false;

            // 모음 3개 혹은 자음 3개가 연속적으로 오면 false
            if (hasThree(pw)) flag = false;

            // 같은 글자가 연속적으로 두번 오면 false (ee, oo는 ㄱㅊ)
            if (hasSameChar(pw)) flag = false;

            if (flag) System.out.printf("<%s> is acceptable.\n", pw);
            else System.out.printf("<%s> is not acceptable.\n", pw);
        }
    }

    private static boolean hasSameChar(String pw) {
        boolean flag = false;
        for (int i = 1; i < pw.length(); i++) {
            char curr = pw.charAt(i);
            char pre = pw.charAt(i - 1);

            if (pre == 'o' || pre == 'e') continue;

            if (curr == pre) {
                flag = true; // 같은거 가지고 있어
                break;
            }
        }
        return flag;
    }

    private static boolean hasThree(String pw) {
        boolean flag = false; // 연속적이지 않을 거야
        String vowels = "aeiou";

        // 비교 대상
        char c = pw.charAt(0);
        int p = vowels.contains(c + "") ? 2 : 1; // 모음이면 2, 자음이면 1
        int cnt = 1;

        for (int i = 1; i < pw.length(); i++) {
            char next = pw.charAt(i);
            int nextP = vowels.contains(next + "") ? 2 : 1;

            if (p == nextP) {
                cnt++;
                if (cnt == 3) flag = true; // 연속 3개 맞아
            }
            else cnt = 1;

            p = nextP;
        }
        return flag;
    }

    private static boolean includeVowel(String pw) {
        String vowels = "aeiou";

        boolean flag = false; // 없을 거야
        for (int i = 0; i < pw.length(); i++) {
            if (vowels.contains(pw.charAt(i) + "")) flag = true; // 모음 있구나
        }

        return flag;
    }
}
