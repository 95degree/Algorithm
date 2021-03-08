public class ForZero {
    public static int solution(int n, int k){
        int answer =0;
        while(true){
            int target = (n/k)*k;
            answer+=(n-target); // n에서 k로 나눠지는 가장 가까운 수로 이동 or k보다 작으면 n그대로//
            n=target;
            if(n<k)
                break;
            answer++;
            n/=k;
        }
        answer+=n-1; // ex)7을 1로 만들려면 6번 이니까 결국 7-1과 같다., 일일이 -1해 줄 필요가 없다.//
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,25));
        System.out.println(solution(25,5));
    }
}
