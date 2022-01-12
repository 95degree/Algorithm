import java.io.*;
import java.util.*;
class Main {
	
	static StringBuilder sr = new StringBuilder();
	static int m, n;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		input();
		output();
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n+1];
		m = sc.nextInt();
		for(int i = 1; i<n+1; i++){
			nums[i] = sc.nextInt();
		}
	}

	static void output() {
		System.out.println(twoPointer());
	}
	
	static int twoPointer(){
		int answer = n+1;
		int right = 0;
		int sum = 0;
		for(int left =1; left<n+1; left++){
			sum -= nums[left-1];
			while(right+1<=n && sum<m){
				right++;
				sum += nums[right];
			}
			if(sum>=m){
				answer = Math.min(answer,right-left+1);
			}
		}
        if(answer == n+1){
            answer = 0;
        }
		return answer;
	}
}
