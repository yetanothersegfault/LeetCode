public class ToeplitzMatrix {
	public static void main(String[] args)
	{
		int[][] matrix = {
			{1,2,3,4},
			{5,5,2,3},
			{9,5,1,2}
		};
		
		ToeplitzMatrix solution = new ToeplitzMatrix();
		solution.isToeplitzMatrix(matrix);
	}
	
	public boolean isToeplitzMatrix(int[][] matrix)
	{
		boolean isToeplitz = true;
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				//check to see if we are on the left or top edge
				if(!((i - 1) < 0 || (j - 1) < 0))
				{
					//check current value to one that is one up and left
					if(matrix[i][j] != matrix[i - 1][j - 1])
					{
						//they are not equal so the matrix cannot be toeplitz
						isToeplitz = false;
						//we want to be able to break out without checking the rest of the matrix
						//no point in checking the rest, we have already found a value that doesn't word
						i = matrix.length;
						break;
					}
				}
			}
		}
		
		return isToeplitz;
	}
}
