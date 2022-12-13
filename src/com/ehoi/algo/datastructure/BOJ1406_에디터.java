package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 텍스트를 입력받는다.
        String text = br.readLine();
        // 명령어 수를 입력받는다.
        int comm = Integer.parseInt(br.readLine());
        // 반복을 돌면서 명령에 따라 수행할 함수를 호출한다.
        // 스택 두 개 미리 만들어놓기
        Stack<Character> fromBottom = new Stack<>(); // 기본
        // 여기에 텍스트 넣어두기
        for (int i = 0; i < text.length(); i++) {
            fromBottom.add(text.charAt(i));
        }
        Stack<Character> fromTop = new Stack<>(); // 옮겨둘 애
        for (int i = 0; i < comm; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L": // 커서 왼쪽으로 이동 : 다른 스택에 옮기기
                    if (fromBottom.isEmpty()) continue;
                    fromTop.add(fromBottom.pop());
                    break;
                case "D": // 커서 오른쪽으로 이동 : 다른 스택에 있는 거 원래 스택으로 옮기기
                    if (fromTop.isEmpty()) continue;
                    fromBottom.add(fromTop.pop());
                    break;
                case "B": // 지우기 : 원래 스택 맨 위에꺼 pop()
                    if (fromBottom.isEmpty()) continue;
                    fromBottom.pop();
                    break;
                case "P": // 커서 왼쪽에 문자 추가하기 : 원래 스택에 추가하기
                    String plus = st.nextToken();
                    fromBottom.add(plus.charAt(0));
                    break;
            }
        }

        // StringBuilder를 사용해서 편집된 텍스트 -> 출력
        StringBuilder ans = new StringBuilder();
        // 원래 스택에 있는 거 다 꺼내서 reverse하고 다른 스택에 있는거 갖다 붙이기
        while (!fromBottom.isEmpty()) {
            ans.append(fromBottom.pop());
        }
        ans.reverse();
        while (!fromTop.isEmpty()) {
            ans.append(fromTop.pop());
        }
        bw.write(ans.toString());
        bw.close();
        br.close();
    }
}
