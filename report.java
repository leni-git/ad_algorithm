package programmers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

	public class report {
		
		public static void main(String[] args) {
		
			String[] id_list = {"muzi", "frodo", "apeach", "neo"};
			String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
			int k = 2;
		
	        int[] answer = {};
	        answer = new int[id_list.length];
	        // 최종 출력 개수 = id_list의 개수

	        // set: 데이터 중복 저장 할 수 없으며, 입력 순서대로의 저장순서를 보장 받을 수 없는 자료구조
	        // HashSet : Set 인터페이스 구현, 순서가 필요 없는 데이터를 HashTable에 저장
	        // HashMap : Key - value 형식 데이터 저장. 중복된 Key값 허용 않음 add 메서드

	        // reportedMap : 신고된ID, 신고한ID들로 구성 - key는 유저ID(신고된ID), value = 중복 않는 HashSet
	        // answerMap 신고된ID, 메일 수 HashMap

	        Map<String, HashSet<String>> reportedMap = new HashMap<>();
	        Map<String, Integer> answerMap = new HashMap<>();

	        for(int i=0; i<id_list.length; i++){
	            HashSet<String> reportingId = new HashSet<>();

	            reportedMap.put(id_list[i], reportingId);
	            answerMap.put(id_list[i], 0);
	        }

	        // 신고자 구하기
	        for(String r : report) {
	            String[] reportStr = r.split(" ");
	            String reportId = reportStr[0];
	            String reportedId = reportStr[1];

	            // 신고된 ID를 키 값, 신고한 ID 배열을 value로 신고된ID=신고한ID 배열
	            reportedMap.get(reportedId).add(reportId);
	        }

	        // 유저가 받은 이용 정지 결과 메일 세팅
	        for(String reportedUser : reportedMap.keySet()) {
	            HashSet<String> userForSend = reportedMap.get(reportedUser);

	            // k번 이상 초과시
	            if(userForSend.size() >= k) {
	                for(String userId : userForSend) {
	                    answerMap.put(userId, answerMap.get(userId) + 1);
	                }
	            }
	        }

	        // 유저ID 별 받은 메일 수를 answer 에 세팅

	        for (int i = 0; i < id_list.length; i++) {
	            answer[i] = answerMap.get(id_list[i]);
	        }
	        
	        System.out.println("FINAL RESULT : "+ Arrays.toString(answer));

	    }
	    
	}

