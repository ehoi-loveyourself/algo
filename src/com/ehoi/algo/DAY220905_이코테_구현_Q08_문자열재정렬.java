package com.ehoi.algo;

import java.util.*;

/*
 * [문제]
 * 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어집니다.
 * 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에, 그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.
 */

/*
 * [풀이]
 * 문자열을 char와 int로 구분해서 리스트에 담고
 * char는 sort하고
 * int는 합할까?
 */

public class DAY220905_이코테_구현_Q08_문자열재정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        List<Character> charList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                // 알파벳 대문자라면
                charList.add(ch);
            } else {
                // 숫자라면
                sum += ch - '0';
            }
        }
        // 알파벳 정렬 : 오름차순 정렬
        charList.sort(Comparator.naturalOrder());

        // 정답 가공
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            ans.append(charList.get(i));
        }
        // 합이 0인 경우에는 합치면 안됨!
        if (sum != 0) ans.append(sum);

        // 정답 출력
        System.out.println(ans.toString());
    }
}
