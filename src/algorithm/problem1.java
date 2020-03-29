package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class problem1 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new FileReader("C:\\Users\\jang\\eclipse-workspace\\Example\\src\\algorithm\\input.txt")));
        System.out.println("이거: "+br);
        // the number of cases, n
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int numberOfJobs = Integer.parseInt(br.readLine());
            int[][] job = new int[numberOfJobs][3];
            for (int j = 0; j < numberOfJobs; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < 3; k++) job[j][k] = Integer.valueOf(line[k]);
            }
            System.out.println("답: "+solution(job));
        }

    }

    public static int maxOfDays = -1;
    public static int[][] p;

    public static int solution(int[][] part_times) {

        for (int i = 0; i < part_times.length; i++) {
            if (maxOfDays < part_times[i][1]) maxOfDays = part_times[i][1];
        }

        p = new int[maxOfDays + 1][maxOfDays + 1];

        for (int i = 0; i < part_times.length; i++) {
            p[part_times[i][0]][part_times[i][1]] = part_times[i][2];
        }

        return P(1, maxOfDays);
    }

    // P[i,j] = max_k=itoj( P(i,k) + P(k,j) )
    public static int P(int i, int j) {
        if (i == j) return 0;
        else {
            // 값이 있으면 리턴
            if (p[i][j] > 0) return p[i][j];
            // 없으면 계산
            else {
                int max = 0;

                for (int k = i + 1; k < j; k++) {
                    int sum = P(i, k) + P(k, j);
                    if (sum > max) max = sum;
                    System.out.println("sum: "+sum+"  max: "+max+" i: "+i+" k: "+k+" j: "+j);
                }

                // memoization
                p[i][j] = max;
                System.out.println("p["+i+"]["+j+"]="+max);
                return max;
            }
        }
    }

}
