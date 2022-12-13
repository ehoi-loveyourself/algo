package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int rear = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            if (comm.equals("push")) {
                rear = Integer.parseInt(st.nextToken());
                queue.add(rear);
            } else if (comm.equals("pop")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.poll() + "\n");
            } else if (comm.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (comm.equals("empty")) {
                if (queue.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else if (comm.equals("front")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.peek() + "\n");
            } else if (comm.equals("back")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(rear + "\n");
            }
        }
        bw.close();
        br.close();
    }
}
