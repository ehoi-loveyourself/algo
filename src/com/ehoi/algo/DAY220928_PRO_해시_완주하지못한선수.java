package com.ehoi.algo;

import java.util.*;

public class DAY220928_PRO_해시_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 확인
        for (int i = 0; i < participant.length; i++) {
            // 다 통과했는데 마지막 한 사람이 남았다면?
            if (i == completion.length) {
                answer = participant[i];
                break;
            }

            // 순서가 다르다면 통과 못했다
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}