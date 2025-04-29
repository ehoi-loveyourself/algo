package com.ehoi.algo.hash;

import java.util.*;

public class Level3_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르, 재생횟수, id를 묶어서 하나의 Music으로 관리하자. 그리고 key는 장르, value는 음악 리스트
        Map<String, List<Music>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            Music music = new Music(genre, plays[i], i);

            if (genreMap.get(genre) == null) {
                List<Music> list = new ArrayList<>();
                list.add(music);
                genreMap.put(genre, list);

            } else {
                genreMap.get(genre).add(music);
            }
        }

        // 2. 이제 장르별로 재생 횟수를 누적시켜야해
        Map<String, Integer> playCntByGenre = new HashMap<>();
        for (Map.Entry<String, List<Music>> entry : genreMap.entrySet()) {
            int total = 0;
            for (Music music : entry.getValue()) {
                total += music.getPlayCnt();
            }

            playCntByGenre.put(entry.getKey(), total);
        }

        // 3. playCntByGenre 를 재생횟수가 높은 순으로 정렬시키자
        List<String> sortedGenre = new ArrayList<>(playCntByGenre.keySet());
        Collections.sort(sortedGenre, (a, b) -> playCntByGenre.get(b) - playCntByGenre.get(a));

        // 4. 높은 재생순으로 장르가 정렬됨. 순서대로 돌면서 음악을 두개씩 뽑자
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenre) {
            List<Music> musicList = genreMap.get(genre);
            Collections.sort(musicList); // 음악 정렬부터 하고

            int cnt = 0;
            for (Music music : musicList) {
                if (cnt == 2) break;
                result.add(music.getId());

                cnt++;
            }
        }

        // 5. 리턴 형태가 int[] 이므로 여기에 담자
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public class Music implements Comparable<Music> {
        private String genre;
        private int playCnt;
        private int id;

        public int getPlayCnt() {
            return this.playCnt;
        }

        public int getId() {
            return this.id;
        }

        public Music(String genre, int playCnt, int id) {
            this.genre = genre;
            this.playCnt = playCnt;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            if (this.playCnt == other.playCnt) {
                return this.id - other.id;
            }
            return other.playCnt - this.playCnt;
        }
    }
}