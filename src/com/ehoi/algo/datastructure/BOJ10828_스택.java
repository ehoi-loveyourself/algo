package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10828_스택 {
    static ArrayList<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 명령 수 입력받고
        int N = Integer.parseInt(st.nextToken());
        stack = new ArrayList<>();
        // 그 수만큼 반복 돌면서 명령 수행
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                push(num);
            } else if (command.equals("top")) {
                top();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("empty")) {
                empty();
            }
        }
    }

    // push X : 정수 X를 스택에 넣는 연산
    private static void push(int x) {
        stack.add(x);
    }
    // pop : 가장 위에 있는 정수를 빼고, 그 수를 출력, 없으면 -1을 출력
    private static void pop() {
        if (stack.size() == 0) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
    }
    // size : 스택에 있는 정수의 개수 출력
    private static void size() {
        System.out.println(stack.size());
    }
    // empty : 스택이 비어있으면 1, 아니면 0 출력
    private static void empty() {
        if (stack.size() == 0) System.out.println(1);
        else System.out.println(0);
    }
    // top : 스택의 가장 위에 있는 정수 출력, 없으면 -1 출력
    private static void top() {
        if (stack.size() == 0) System.out.println(-1);
        else System.out.println(stack.get(stack.size() - 1));
    }
}
