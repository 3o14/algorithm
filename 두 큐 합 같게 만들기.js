function solution(queue1, queue2) {

    // 두 큐의 합을 같게 만들 수 없는 경우
    let answer = -1; 

    //reduce메소드를 이용해 큐의 원소를 모두 합함
    let sum1 = queue1.reduce((pre,cur)=>pre+cur,0); 
    let sum2 = queue2.reduce((pre,cur)=>pre+cur,0);

    // 두 큐를 모두 합한 값의 반
    const middle = (sum1+sum2)/2;

    // concat메소드를 이용한 큐1과 큐2를 합한 새로운 배열 temp 생성 
    let temp = queue1.concat(queue2);

    // 투포인터 left, right 이용
    let left = 0, right = queue1.length, count = 0;
    const len = temp.length;


    while(count < 2*len){
        if(sum1 > middle){
            sum1-=temp[left];
            if(left < len-1)
                left++;
            else
                left = 0;
        }
        else if(sum1<middle){
            sum1+=temp[right];
            if(right < len-1)
                right++;
            else
                right=0;
        }
        else
            return count;
        count++;
    }
    return answer;
}