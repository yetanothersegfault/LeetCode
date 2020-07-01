public class CountNegatives {
	
	public static void main(String[] args)
	{
		int[][] grid = {
				{-1}
		};
		
		CountNegatives solution = new CountNegatives();
		int sol = solution.countNegatives(grid);
	}
	
	public int countNegatives(int[][] grid)
	{
		//count how many negative numbers
		int count = 0;
		//for loop for each row in grid
		for(int i = 0; i < grid.length; i++)
		{
			//set j to be the size of the sub array minus 1
			//we want to traverse the array backwards so we only check for negative numbers
			int j = grid[i].length - 1;
			while(j >= 0 && grid[i][j] < 0)
			{
				//we have a negative number
				count++;
				j--;
			}
		}
		
		return count;
	}
}
