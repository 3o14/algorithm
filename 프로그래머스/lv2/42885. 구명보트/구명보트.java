import java.util.Arrays;
// 배열 정렬 후 양 끝 두 요소를 더한 값이 limit보다 작을 경우 ans++
// 클 경우는 ans++
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        
        Arrays.sort(people);
        
        for(int i=people.length-1; i >= idx; i--){
            int boat = people[i] + people[idx];
            if (boat <= limit){
                answer++;
                idx++;
            } else {
                answer++;
            }
        }    
        
        return answer;
    }
}