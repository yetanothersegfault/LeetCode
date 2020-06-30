import java.util.ArrayList;
import java.util.List;

public class MaxLevelSum
{
	public static void main(String[] args)
	{
		TreeNode left = new TreeNode(7, null, null);
		TreeNode right = new TreeNode(-8, null, null);
		TreeNode root = new TreeNode(7, left, right);
		
		left = root;
		right = new TreeNode(0, null, null);
		root = new TreeNode(1, left, right);
		MaxLevelSum solution = new MaxLevelSum();
		int sol = solution.maxLevelSum(root);
	}
	
	public int maxLevelSum(TreeNode root)
	{
		//get all nodes in next level down
		List<TreeNode> row = new ArrayList<TreeNode>();
		int level = 1;
		//check and add both nodes to list
		if(root.left != null)
			row.add(root.left);
		if(root.right != null)
			row.add(root.right);
		
		List<Integer> highest = null;
		
		//recursivly get the highest value from bottom up
		if(row.size() != 0)
			highest = traverse(row, (level + 1));
			
		//the root only has one value so we don't have to add that up
		int value = root.val;
		
		//check current highest with the root
		//if the current highest value is higher we replace the level with the level which was the highest
		if(highest != null && highest.get(1) > value)
			level = highest.get(0);
		
		return level;
	}
	
	public List<Integer> traverse(List<TreeNode> row, int level)
	{
		//track the value of current row
		int value = 0;
		
		List<TreeNode> next = new ArrayList<TreeNode>();
		
		//get all the nodes connected and put them in the list to send down to next level
		//add up value of current row
		for(int i = 0; i < row.size(); i++)
		{
			//get node
			TreeNode node = row.get(i);
			//check and add left and right nodes
			if(node.left != null)
				next.add(node.left);
			if(node.right != null)
				next.add(node.right);
			//add value
			value += node.val;
		}
		List<Integer> highest = null;
		
		//go to next level down if it exists
		if(next.size() != 0)
			highest = traverse(next, (level + 1));
		
		//the highest won't contain a value unless it went down to the next row
		if(highest != null)
		{
			//means we traversed down to the next level
			if(value > highest.get(1))
			//the value on the current highest is greater than the previous highest
			highest = new ArrayList<Integer>();
			highest.add(level);
			highest.add(value);
		}
		else
		{
			//get here when we reach the bottom of the tree need to make a highest
			highest = new ArrayList<Integer>();
			highest.add(level);
			highest.add(value);
		}
		
		return highest;
	}
}
