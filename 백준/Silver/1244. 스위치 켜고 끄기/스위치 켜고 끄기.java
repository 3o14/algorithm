import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int start, end = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int switchNum = Integer.parseInt(br.readLine()); // 스위치 개수
		String[] tmp = br.readLine().split(" ");

		// 입력
		int[] status = new int[switchNum + 1];
		for (int i = 0; i < tmp.length; i++) {
			status[i+1] = Integer.parseInt(tmp[i]);
		}

		// 학생 정보 입력
		int studentNum = Integer.parseInt(br.readLine());
		while (studentNum-- > 0) {
			String[] line = br.readLine().split(" ");
			int gender = Integer.parseInt(line[0]);
			int num = Integer.parseInt(line[1]);

			if (gender == 1) { // 남학생
				for (int j = 1; j <= switchNum / num; j++) {
					if (status[num * j] == 1) {
						status[num * j] = 0;
					} else {
						status[num * j] = 1;
					}
				}
			} else if (gender == 2) { // 여학생
				changeStatus(num, status, 1);

				if (end != 1) {
					for (int j = start; j <= end; j++) { // 가장 많은 대칭 범위를 상태변경?
						if (status[j] == 1) {
							status[j] = 0;
						} else {
							status[j] = 1;
						}
					}
					start = 1;
					end = 1;
				}
				else {
					if (status[num] == 1) {
						status[num] = 0;
					} else {
						status[num] = 1;
					}
				}
			}
		}
		// 출력
		for (int i = 1; i <= switchNum; i++) {
			System.out.print(status[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	public static void changeStatus(int index, int[] status, int i) {
		if (index - i >= 1 && index + i < status.length) {
			if (status[index - i] == status[index + i]) { // 대칭이면
				start = index - i;
				end = index + i;
				changeStatus(index, status, i + 1);
			}
			return;
		}
		return;
	}
}
