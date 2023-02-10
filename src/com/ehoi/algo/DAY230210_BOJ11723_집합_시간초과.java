package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230210_BOJ11723_집합_시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            all.add(i);
        }

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
                    // 이미 x가 있다면
                    boolean flag = false; // 없을 거야

                    for (Integer integer : list) {
                        if (integer == x) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        list.add(x);
                    }
                    break;
                }
                case "remove":
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) == x) {
                            list.remove(j);
                            break;
                        }
                    }
                    break;
                case "check": {
                    boolean flag = false;
                    for (Integer integer : list) {
                        if (integer == x) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "toggle": {
                    boolean flag = false;
                    for (Integer integer : list) {
                        if (integer == x) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) list.remove((Object) x);
                    else list.add(x);
                    break;
                }
                case "all":
                    list = all;
                    break;
                case "empty":
                    list = new ArrayList<>();
                    break;
            }
        }
    }
}
