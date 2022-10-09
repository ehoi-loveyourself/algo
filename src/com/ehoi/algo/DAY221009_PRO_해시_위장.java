package com.ehoi.algo;

import java.util.*;

public class DAY221009_PRO_해시_위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        // 입력
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        // 총 가짓수 구하기
//        for (Integer integer : map.values()) {
//            answer *= integer + 1;
//        }

        // 내가 위와 같이 풀어내지 못할 수도 있으니까
        for (int i = 0; i < clothes.length; i++) {
            answer *= map.get(clothes[i][1]) + 1;
            map.put(clothes[i][1], 0); // 이미 계산된 타입은 0으로 초기화 시켜서 다음에 계산되지 않게 하기
        }

        return answer - 1;
    }
}
