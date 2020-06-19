import java.util.Hashtable;
import java.util.ArrayList;

public class TwoSum {

	public static void main(String[] args)
	{
		int[] nums = {3, 2, 4};
		int target = 6;
		TwoSum twosum = new TwoSum();
		int[] solution = new int[2];
		try
		{
			solution = twosum.twoSum(nums, target);
		}
		catch(IllegalAccessError e)
		{
			System.out.println(e);
		}
		System.out.println(solution[0] + " " + solution[1]);
	}
	
	public int[] twoSum(int[] nums, int target) throws IllegalAccessError
	{
		int[] retVal = new int[2];
		
		//create HashTable
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		
		int i = 0;
		boolean found = false;
		//go through each element of array and see if there is a match
		//if not add value to hash map
		while(!found && i < nums.length)
		{
			//get value of number we need to see is in the hashtable
			int toFind = target - nums[i];
			if(hash.containsKey(toFind))
			{
				//we know the value we are looking for is in the hash map
				//get current location in array
				retVal[0] = hash.get(toFind);
				//get the location give to us by the hashtable
				retVal[1] = i;
				found = true;
			}
			else
			{
				//current toFind was not found in hashtable
				//put current value from array into hashtable
				hash.put(nums[i], i);
			}
			i++;
		}
		if(!found)
		{
			throw new IllegalArgumentException("No Solution");
		}
		else
		{
			return retVal;
		}
	}
}
