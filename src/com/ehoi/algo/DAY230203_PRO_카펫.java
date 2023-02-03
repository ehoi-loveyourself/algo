package com.ehoi.algo;

public class DAY230203_PRO_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 노란색으로 완전 탐색
        for (int i = 1; i * i <= yellow; i++) {
            // i 가 세로고 나뉜 게 가임 가로 + 2 * 세로 * 2를 한게 brown + yellow 와 같으면 그 가로와 세로가 정답임
            if ((i + 2) * ((yellow / i) + 2) == (brown + yellow)) {
                answer[1] = i + 2;
                answer[0] = (yellow / i) + 2;
            }
        }

        return answer;
    }
}