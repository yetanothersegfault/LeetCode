public class IsValidBST {
	
	public static void main(String[] args)
	{
		TreeNode left = new TreeNode(3, null, null);
		TreeNode right = new TreeNode(6, null, null);
		TreeNode root = new TreeNode(4, left, right);
		left = new TreeNode(1, null, null);
		right = root;
		root = new TreeNode(5, left, right);
		IsValidBST solution = new IsValidBST();
		boolean isValid = solution.isValidBST(root);
	}
	
	public boolean isValidBST(TreeNode root)
	{
		boolean isValid = true;
		//check to see if root is null
		if(root == null)
			return true;
		//check to see if we are at the bottom of the tree
		if(root.left == null && root.right == null)
		{
			return true;
		}
		else
		{
			//call is valid on left node
			if(root.left != null)
			{
				isValid = isValidBST(root.left);
			}
			
			//call is valid on right node
			if(root.right != null)
			{
				isValid = isValidBST(root.right);
			}
			
			//check to see if previous return was true or false
			if(isValid)
			{
				//check both values of tree
				
				//make sure node isn't null
				if(root.left != null)
				{
					//left side has to be less than root
					if(!(root.val > root.left.val))
						isValid = false;
				}
				
				//again check the right node to see if it's null
				if(root.right != null)
				{
					//right side has to be greater than root
					if(!(root.val < root.right.val))
						isValid = false;
				}
			}
			
		}
		return isValid;
	}
}
