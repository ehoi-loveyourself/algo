package com.ehoi.algo.lecture;

import java.util.Scanner;
import java.util.Stack;

public class Lec55_기차운행_스택활용 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        // 1. 기차 개수만큼 포문을 돈다.
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int train = sc.nextInt();
            // 2. 기차를 스택에 넣는다.
            stack.push(train);
            sb.append("P");
            // 3. 스택에서 조회한다. 현재 나와야 하는 기차인지 확인한다.
            while (!stack.isEmpty()) {
                // 5. while로 반복해서 스택에서 꺼내서 확인하는 작업을 한다
                // 4. 맞으면 꺼내고 현재 나와야 하는 기차 ++
                if (num == stack.peek()) {
                    num++;
                    stack.pop();
                    sb.append("O");
                    // 6. 다르다면 그 다음 포문으로 넘어간다
                } else break;
            }
        }
        // 7. 포문을 끝내고 나왔는데 스택이 비어있지 않다면 impossible 출력
        if (!stack.isEmpty()) System.out.println("impossible");
        else System.out.println(sb);
        // 8. 그게 아니라면 sb 출력
        sc.close();
    }
}
