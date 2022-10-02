package com.ehoi.algo;

import java.util.HashSet;
import java.util.Set;

public class DAY221002_PRO_해시_폰켓몬_리팩토링 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]); // 종류를 집어 넣는다.
        }

        return Math.min(nums.length/2, set.size());
    }
}
