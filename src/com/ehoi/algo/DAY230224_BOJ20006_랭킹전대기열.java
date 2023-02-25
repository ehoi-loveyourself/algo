package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DAY230224_BOJ20006_랭킹전대기열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원 수

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            // 입장할 방이 있는지 서치
            // 방들 중에서
            boolean flag = false; // 입장 플래그
            for (Room room : rooms) {
                // 처음 입장한 플레이어의 레벨을 확인한다.
                int first = room.users.get(0).level;
                // 정원이 가득찬 방이라면 다음 방으로 넘어간다.
                if (room.users.size() >= m) continue;
                // 입장하려는 유저의 레벨이 입장 가능하다면
                if (first - 10 <= level && level <= first + 10) {
                    room.users.add(new User(level, name)); // 입장시킨다.
                    flag = true;
                    break;
                }
            }
            // 입장 못했다면 새롭게 방을 생성하고 입장시킨다.
            if (!flag) {
                Room newRoom = new Room();
                newRoom.users.add(new User(level, name));
                rooms.add(newRoom); // 이걸 해조야지 이거를!
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            // 그리고 이제 유저들을 sort한다.
            Collections.sort(room.users);
            // 정원이 찼다면
            if (room.users.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }
            for (User user : room.users) {
                sb.append(user.level).append(" ").append(user.name).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static class Room {
        // 이 게임방은 유저들이 들어온다
        List<User> users = new ArrayList<>();
    }

    private static class User implements Comparable<User> {
        // 유저는 레벨과 닉네임으로 구성되어 있다.
        private int level;
        private String name;

        public User(int level, String name) {
            this.level = level;
            this.name = name;
        }

        // 닉네임 사전순으로 정렬한다.
        @Override
        public int compareTo(User o) {
            return this.name.compareTo(o.name);
        }
    }
}
