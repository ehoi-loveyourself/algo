package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String ans = "YES";
            String str = br.readLine(); // 괄호 입력
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        ans = "NO";
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                ans = "NO";
            }
            bw.write(ans + "\n");
        }
        bw.close();
        br.close();
    }
}
