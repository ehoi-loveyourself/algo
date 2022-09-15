package com.ehoi.algo;

public class DAY220916_PRO_구현_문자열압축 {
    public int solution(String s) {
        // 정답의 최대는 문자열의 길이다.
        int answer = s.length();
        // 자르는 단위별(i)로 포문 돌리기 단위를 1부터 s.length/2까지 돌린다
        for (int i = 1; i <= s.length() / 2; i++) {
            // 압축된 문자열을 담을 변수 정의
            String compressed = "";
            // 기준이 될 단위만큼 자른 문자열을 가져온다.
            String pivot = s.substring(0, i);
            // 압축 횟수 = 1 로 초기화한다.
            int cnt = 1;
            // j는 단어 끝까지 i만큼 점프하며 커지고
            for (int j = i; j < s.length(); j = j + i) {
                String chunk = "";
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) chunk += s.charAt(k);
                }
                // 그만큼 자른 아이(ch)와 pivot을 비교해서 같으면
                if (chunk.equals(pivot)) {
                    // 압축 횟수를 증가시킨다.
                    cnt++;
                    // 다르면
                } else {
                    // 압축 문자열에 기준 문자열을 넣는다. 이때 cnt가 1보다 크면 cnt를 먼저 붙이고, 작으면 바이
                    if (cnt > 1) {
                        compressed += cnt;
                    }
                    compressed += pivot;
                    // cnt는 1로 다시 초기화
                    cnt = 1;
                    // pivot 재설정
                    pivot = chunk;
                }
            }
            // 다 하고 나와서 마지막까지 같아서 문자열에 들어오지 못한 아이들 정리하고
            if (cnt > 1) {
                compressed += cnt;
            }
            compressed += pivot;
            // 문자열 길이 새서 answer이랑 min 비교하기
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
