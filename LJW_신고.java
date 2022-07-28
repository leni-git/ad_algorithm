import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet; 
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
     
        int[] answerList = new int[id_list.length];

		HashMap<String, HashSet<String>> userMap = new HashMap<String,HashSet<String>>();
		for(String s:report){
			String reportUser = s.split(" ")[0];
			String answerUser = s.split(" ")[1]; 
			if(userMap.containsKey(answerUser)){
				userMap.get(answerUser).add(reportUser);
			}else{
				userMap.put(answerUser,new HashSet<>( Arrays.asList(reportUser)));
			}
		}
		
		int idx = 0;
		for(String id:id_list){
	        for (Entry<String, HashSet<String>> userSet : userMap.entrySet()) {   
	        	if(userSet.getValue().size() >= k){
	        		if(userSet.getValue().contains(id)){
	        			answerList[idx]++;
	        		}
	        	}       
	        }
	        idx++;
		}
 
		return answerList;
 
    }
}