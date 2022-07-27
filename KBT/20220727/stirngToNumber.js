function solution(s) {
    let answer = "";
    let index = 0;
    
    for(let i=0; i<s.length; i++) {        
        // 숫자의 경우 바로 추가
        if(!isNaN(s[i])) {
            answer += s[i];
            index++;
        } else {
            // 문자열의 경우 변환한 뒤 추가
            const result = changeToNumber(s.slice(index, i+1));

            if(result) {
                answer += result;
                index = i+1;
            } 
        }
    }
    
    // 숫자형으로 형변환
    return answer*1;
}

// 문자열을 숫자로 바꾸어주는 함수
function changeToNumber(str) {
    switch(str) {
        case "one" : return "1";
        case "two" : return "2";
        case "three" : return "3";
        case "four" : return "4";
        case "five" : return "5";
        case "six" : return "6";
        case "seven" : return "7";
        case "eight" : return "8";
        case "nine" : return "9";
        case "zero" : return "0";
        default : return false;
    }
}
