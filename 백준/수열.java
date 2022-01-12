import java.io.*;
import java.util.*;
public class Main {
	
	static StringBuilder sr = new StringBuilder();
	static int n, k;
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
		k = sc.nextInt();
		for(int i = 1; i<n+1; i++){
			nums[i] = sc.nextInt();
		}
	}

	static void output() {
		System.out.println(twoPointer());
	}
	
	static int twoPointer(){
		int right = k;
		int sum =0;
		for(int i =1; i<=k; i++){
		    sum += nums[i];
		}
		int answer = sum;
		for(int left=2; left<n+1; left++){
		    if(right+1>n){
                break;
            }
			sum -= nums[left-1];
			right++;
			sum += nums[right];
			if(sum>answer){
				answer = sum;
			}
		}
		return answer;
	}
}
