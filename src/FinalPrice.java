public class FinalPrice {
	
	public static void main(String[] args)
	{
		int[] prices = {10, 1, 1, 6};
		FinalPrice solution = new FinalPrice();
		int[] sol = solution.finalPrice(prices);
	}
	
	public int[] finalPrice(int[] prices)
	{
		//loop through each element
		for(int i = 0; i < (prices.length - 1); i++)
		{
			//want to use next element and beyond in the array
			int j = i + 1;
			boolean foundDiscount = false;
			//traverse the rest of the array and check each value
			//except when we find one to reduce the current price
			while(j < prices.length && !foundDiscount)
			{
				//if there is a valid element which we can reduce the price
				if(prices[j] <= prices[i])
				{
					foundDiscount = true;
					prices[i] = prices[i] - prices[j];
				}
				j++;
			}
		}
		return prices;
	}
}
