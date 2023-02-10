package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 결국 비트마스킹이 아니면 안되는 거였어.. ㅎ
public class DAY230210_BOJ11723_집합_시간초과2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        int m = Integer.parseInt(st.nextToken()); // 연산의 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken(); // 명령
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken()); // 수
            }

            switch (str) {
                case "add": {
                    // 셋이라면 중복을 허용하지 않으므로 그냥 넣으면 된다.
                    set.add(x);
                    break;
                }
                case "remove":
                    set.remove(x);
                    break;
                case "check": {
                    if (set.contains(x)) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "toggle": {
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                }
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
    }
}
