package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.Stack;

public class BOJ10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }
        bw.write(ans + "");
        bw.close();
        br.close();
    }
}
