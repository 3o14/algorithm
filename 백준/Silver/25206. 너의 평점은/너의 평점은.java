import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 학점 * 등급
// 학점 총합
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		double sum = 0; // 학점*등급의 합
		int total = 0; // 학점 총합
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double num = Double.parseDouble(st.nextToken());
			String []grade = st.nextToken().split("");
			total += num;
			double score = 0;
			
			switch(grade[0]) {
			case "A":
				 score = 4;
				 break;
			case "B":
				score = 3;
				break;
			case "C":
				score = 2;
				break;
			case "D":
				score = 1;
				break;
			case "F":
				score = 0;
				break;
			case "P":
				total -= num;
			}
			
			if(grade.length > 1 && grade[1].equals("+"))
				score += 0.5;
			
			sum += num * score;
		}
		System.out.printf("%.6f", sum/total);
		
				
	}
}