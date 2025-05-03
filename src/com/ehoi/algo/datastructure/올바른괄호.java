package com.ehoi.algo.datastructure;

import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        // 홀수라면 바로 false
        if (s.length() % 2 == 1) {
            return false;
        }

        // 처음이나 끝
        char front = s.charAt(0);
        char rear = s.charAt(s.length() - 1);
        if (front == ')' || rear == '(') return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}