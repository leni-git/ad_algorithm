function solution(participant, completion) {
    let answer = '';
    
    // 효율성 통과를 오름차순 위한 정렬
    participant.sort();
    completion.sort();
    
    // 완주자 체크
    for(let i=0, index=0; i<participant.length; i++, index++) {
        // 정렬하였으니 참가자와 완주자가 일치하지 않으면 완주자 index - 1 처리
        if(participant[i] !== completion[index]) {
            answer += (participant[i]+" ");
            index--;
        }
    }
    
    // 마지막 스페이스바 제거
    answer = answer.substring(0, answer.length-1);
    
    return answer;
}
