import java.util.ArrayList;

public class XorQueries {
	
	public static void main(String[] args)
	{
		int[] arr = {4,8,2,10};
		int[][] queries = {{2,3},{1,3},{0,0},{0,3}};
		
		XorQueries solution = new XorQueries();
		int [] sol = solution.xorQueries(arr, queries);
	}
	
	public int[] xorQueries(int[] arr, int[][] queries)
	{
		ArrayList<Integer> solution = new ArrayList<>();
		for(int i = 0; i < queries.length; i++)
		{
			//get the range we need to iterate over
			int rangeFrom = queries[i][0];
			int rangeTo = queries[i][1];
			
			//get first value
			int value = arr[rangeFrom++];
			
			//get all the remaining values from the arr
			while(rangeFrom <= rangeTo)
			{
				value = value ^ arr[rangeFrom];
				rangeFrom++;
			}
			
			solution.add(value);
			
		}
		
		//transfer the ArrayList to an int array to return
		int[] sol = new int[solution.size()];
		
		for(int i = 0; i < solution.size(); i++) {
			if (solution.get(i) != null) {
				sol[i] = solution.get(i);
			}
		}
		return sol;
	}
}
