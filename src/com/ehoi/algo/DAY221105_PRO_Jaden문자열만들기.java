package com.ehoi.algo;

public class DAY221105_PRO_Jaden문자열만들기 {
    public String solution(String s) {
        String answer = "";

        // 일단 문자열을 소문자로 만들고 배열에 다 집어 넣는다
        String[] arr = s.toLowerCase().split("");
        boolean flag = true; // 대문자여야하는지 판별하는 플래그


        // "첫 단어 + 공백 다음에 단어"의 첫번째 문자
        for (String str : arr) {
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }

        return answer;
    }
}
