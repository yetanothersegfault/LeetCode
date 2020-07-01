

public class FibonacciNumber {
	
	public static void main(String[] args)
	{
		int N = 4;
		FibonacciNumber solution = new FibonacciNumber();
		int sol = solution.fib(N);
		System.out.println(sol);
	}
	
	public int fib(int N)
	{
		if(N == 1)
			return 1;

		if(N == 0)
			return 0;
		
		int ans = fib(N - 1) + fib(N - 2);
		
		return ans;
	}
}
