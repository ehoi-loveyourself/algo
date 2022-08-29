package com.ehoi.algo;

import java.util.*;

public class DAY220929_PRO_완전탐색_모의고사 {
    public int[] solution(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자랑 비교
            if (answers[i] == stu1[i%5]) score[0]++;
            // 2번
            if (answers[i] == stu2[i%8]) score[1]++;
            // 3번
            if (answers[i] == stu3[i%10]) score[2]++;
        }

        // 최고점을 구하자 : 굳이 정렬을 하지 않아도 최고점을 구할 수 있다.. 나는 바보
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        // 최고점을 맞은 사람을 구하자
        List<Integer> maxStu = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if(maxScore == score[i]) {
                maxStu.add(i + 1); // 오름차순으로 학생들이 들어갔다.
            }
        }

        // 정답 배열에 옮겨 닮자
        int[] answer = new int[maxStu.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = maxStu.get(i);
        }

        return answer;
    }
}