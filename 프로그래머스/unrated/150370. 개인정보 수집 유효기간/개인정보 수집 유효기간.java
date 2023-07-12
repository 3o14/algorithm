import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> termsMap = new HashMap<String, Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int i = 1; 
        
        //오늘일자
        today = today.replace(".", "");
        
        //정보저장기간
        for (String term : terms) {
            
            String[] tmp = term.split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
            
        }
        
        //개인정보수집일자
        for (String privacy : privacies) {
            
            String[] tmp = privacy.split(" ");
            
            try {
                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy.MM.dd");
                Date date = transFormat.parse(tmp[0]);

                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(date); // 시간 설정
                cal1.add(Calendar.MONTH, termsMap.get(tmp[1])); // 월 연산
                cal1.add(Calendar.DATE,  -1); //일 연산
                
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                String endDate = format.format(new Date(cal1.getTimeInMillis()));

                if (Integer.parseInt(endDate.substring(6)) > 28){
                    endDate = endDate.substring(0,6)+"28";
                }                
            
            
                if (Integer.parseInt(today) > Integer.parseInt(endDate)) {
                    answerList.add(i);
                }                
                
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }

            i++;
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int j = 0; j < answerList.size(); j++) {
            answer[j] = answerList.get(j);
        }
        
        return answer;
    }
}