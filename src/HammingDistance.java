public class HammingDistance {
	public static void main(String[] args)
	{
		int x = 1, y = 4;
		HammingDistance solution = new HammingDistance();
		int sol = solution.hammingDistance(x, y);
	}
	
	public int hammingDistance(int x, int y)
	{
		int count = 0;
		//exclusive or of both x and y
		int ans = x ^ y;
		
		//get count of all bits that are 1
		while(ans > 0)
		{
			//set up mask
			int mask = 1;
			//use mask to get the low bit
			int lowBit = ans & mask;
			//if the result is 1 then we have a bit in the lowEnd
			if(lowBit == 1)
				count++;
			//shift to the right one using unsigned shift operator
			ans = ans >>> 1;
		}
		return count;
	}
}
