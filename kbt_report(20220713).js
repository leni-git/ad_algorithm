function solution(id_list, report, k) {
    const answer = [];
    
    // 신고 중복제거
    const set = new Set(report);
    const removedArr = [...set];
    
    // 각 id당 신고 당한 수를 체크하도록 명단 생성
    const reportData = [];
    
    id_list.forEach(function(element) {
        const obj = {};
        obj.id = element;
        obj.reported = 0;
        obj.succeed = 0;
        reportData.push(obj);
    });
    
    // 신고 당한 횟수 카운트
    removedArr.forEach(function(element) {
        const ids = element.split(" ");
        const target = ids[1];
        
        for(let i=0; i<reportData.length; i++) {
            if(reportData[i].id === target) {
                reportData[i].reported++;
            }
        }
    });
    
    // 정지 대상자 확인
    const suspend = [];
    
    reportData.forEach(function(element) {
        if(element.reported >= k) {
            suspend.push(element.id);
        }
    });
    
    // 정지 대상자를 신고한 사람 확인
    removedArr.forEach(function(element) {
        const words = element.split(" ");
        
        if(suspend.includes(words[1])) {
            reportData.find(function(e) {
                if(e.id === words[0]) {
                    e.succeed++
                }
            })
        }
    });
    
    // 신고 성공한 횟수 입력
    reportData.forEach(function(element) {
        answer.push(element.succeed);    
    })
    
    return answer;
}
