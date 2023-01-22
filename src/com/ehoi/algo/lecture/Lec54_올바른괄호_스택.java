package com.ehoi.algo.lecture;

import java.util.Scanner;
import java.util.Stack;

public class Lec54_올바른괄호_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) flag = false;
        if (flag) System.out.println("YES");
        else System.out.println("NO");
        // 1. 괄호를 하나씩 읽는다.
        // 2. 여는 괄호이면 스택에 넣는다.
        // 3. 닫는 괄호이면 스택에서 여는 괄호를 하나 빼낸다.
        // 4. 만약 스택이 비어있다면 NO를 출력한다.
        // 5. 괄호가 끝났는데도 여는 괄호가 스택에 남아있다면? NO!
        // 6. 위의 조건을 다 벗어났다면 YES를 출력하면 된다.
        sc.close();
    }
}
