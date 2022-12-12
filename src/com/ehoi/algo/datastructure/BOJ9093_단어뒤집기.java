package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ9093_단어뒤집기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        // 어차피 스택은 빌거니까 계속 새로 만들필요 없어
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < tc; i++) {
            String s = br.readLine();
            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                if (c == ' ') {
                    // 공백이면 스택에 있는 거 전부 출력 후 공백 하나 추가 출력
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(" ");
                } else {
                    // 스택에 담는다.
                    stack.push(c);
                }
            }
            // 마지막 단어
            while (!stack.isEmpty()) {
                bw.write(stack.pop());
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}

// 스택으로 구현하거나
// StringBuffer or StringBuilder reverse() 이용
