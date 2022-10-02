package com.ehoi.algo;

import java.util.*;

public class DAY221002_PRO_해시_폰켓몬 {
    public int solution(int[] nums) {
        int N = nums.length;

        // 종류, 몇 번째 포켓몬
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(nums[i], i);
        }
        int x = map.size();

        return Math.min(x, N / 2);
    }
}
