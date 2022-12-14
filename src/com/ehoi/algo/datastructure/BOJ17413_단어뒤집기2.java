package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.Stack;

public class BOJ17413_단어뒤집기2 {
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문자열을 입력받는다.
        String str = br.readLine();
        // 문자열을 돌면서
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') { // 태그이면
                // 스택에 담아 있던걸 꺼내자
                pop();
                sb.append(c);
                i++;
                while (str.charAt(i) != '>') { // > 를 만날때까지 sb에 append
                    sb.append(str.charAt(i));
                    i++;
                }
                // >다
                sb.append(str.charAt(i));
            } else { // 단어면
                if (c == ' ') {
                    // 공백이면 스택에 빌 때까지 꺼내서 append
                    pop();
                    sb.append(' ');
                } else {
                    // 공백이 아니면 스택에 쌓는다.
                    stack.add(c);
                }
            }
        }
        // 포문을 나와서 스택에 있는 걸 다 꺼낸다.
        pop();
        // 출력한다.
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void pop() {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
