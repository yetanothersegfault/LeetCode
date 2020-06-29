public class DivideTwoIntegers {

	public static void main(String[] args)
	{
		int dividend = 2147483647;
		int divisor = 1;
		DivideTwoIntegers solution = new DivideTwoIntegers();
		int sol = solution.divide(dividend, divisor);
	}

	public int divide(int dividend, int divisor)
	{
		boolean isNeg = false;
		boolean overflow = false;
		//check to see if we have a negative number
		if(dividend < 0 || divisor < 0)
		{
			//check to see if they are both negative
			if(dividend < 0 && divisor < 0)
			{
				dividend -= (dividend + dividend);
				divisor -= (divisor + divisor);
				//if they are both negative then we don't want to set the negative flag
				//because a negative number divided by a negative number is positive
				//check to see if either digit is still negative cause that would indicate an overflow
				if(dividend < 0)
				{
					overflow = true;
				}
				if(divisor < 0)
				{
					overflow = true;
				}
			}
			else
			{
				//check to see if the divisor is greater than zero
				//if so then the dividend is negative
				if(divisor > 0)
				{
					dividend -= (dividend + dividend);
					isNeg = true;
					if(dividend < 0)
						overflow = true;
				}
				else
				{
					//this means that the divisor is negative
					divisor -= (divisor + divisor);
					isNeg = true;
					if(divisor < 0)
						overflow = true;
				}
			}
		}

		int count = 0;
		int start = divisor;
		
		boolean isDivisorOne = false;
		
		if(divisor == 1)
		{
			isDivisorOne = true;
			count = dividend;
		}

		while(start <= dividend && !overflow && !isDivisorOne)
		{
			start += divisor;
			count++;
		}

		if(isNeg)
		{
			count -= (count + count);
		}
		
		if(overflow)
		{
			count = Integer.MAX_VALUE;
		}

		return count;
	}
}
