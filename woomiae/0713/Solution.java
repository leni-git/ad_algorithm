import java.util.*;

// 2022.07.07 문제
// 신고결과 받기
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            idxMap.put(id_list[i], i);
        }

        for (int i=0; i<report.length; i++) {
            String[] strs = report[i].split(" ");
            String from = strs[0];
            String to = strs[1];
            HashSet hashSet = map.get(to);
            hashSet.add(from);
            map.put(to, hashSet);
        }

        for (String key : map.keySet()) {
            if(map.get(key).size() >= k) {
                for (String name : map.get(key)) {
                    answer[idxMap.get(name)]++;
                }
            }
        }

        return answer;
    }
}