import java.util.*;

// 2022.07.14 문제
// 해시 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        Set set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}