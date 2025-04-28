package com.ehoi.algo.hash;

import java.util.*;

public class Level2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 오름차순 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}