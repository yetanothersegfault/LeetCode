import java.util.Arrays;

public class FindLucky {
	
	public static void main(String[] args)
	{
		int[] arr = {4,3,2,2,4,1,3,4,3};
		FindLucky solution = new FindLucky();
		int sol = solution.findLucky(arr);
 	}
 	
 	public int findLucky(int[] arr)
	{
		Arrays.sort(arr);
		int lucky = -1;
		boolean foundLucky = false;
		int i = arr.length - 1;
		
		while(!foundLucky && i >= 0)
		{
			int counter = 1;
			int num = arr[i];
			while(i >= 1 && arr[i -1] == arr[i])
			{
				counter++;
				i--;
			}
			if(counter == num)
			{
				foundLucky = true;
				lucky = num;
			}
			i--;
		}
		
		return lucky;
	}
}
