package com.ehoi.algo;

import java.util.*;

public class DAY221008_PRO_해시_전화번호목록_ver1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        return true;
    }
}
