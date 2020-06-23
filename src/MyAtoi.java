public class MyAtoi {
	public static void main(String[] args)
	{
		String str = "+1";
		MyAtoi convert = new MyAtoi();
		int num = convert.myAtoi(str);
		System.out.println(num);
	}
	
	public int myAtoi(String str)
	{
		//add a digit to the string to be able to find the end if there is just digits
		str = str.concat("a");
		boolean isNeg = false;
		int retVal = 0;
		int prev = 0;
		boolean overflow = false;
		//First remove all white space
		char ch = str.charAt(0);
		
		while(ch == 32)
		{
			str = str.substring(1);
			ch = str.charAt(0);
		}
		//check to see if the first char is a negative sign
		if(ch == 45)
		{
			//reach here if it is a negative sign
			isNeg = true;
			//move to next character is string
			str = str.substring(1);
			ch = str.charAt(0);
		}
		
		//apparently we also have to check for + sign
		if(ch == 43)
		{
			//move one down
			str = str.substring(1);
			ch = str.charAt(0);
			if(isNeg)
			{
				ch = 'a';
			}
		}
		
		//check to see if first char is number or letter
		while(ch >= 48 && ch <= 57 && !overflow)
		{
			//multiple retVal by 10 to move it one to the left
			retVal *= 10;
			//add the next digit
			retVal += ch - 48;
			//get next character
			str = str.substring(1);
			ch = str.charAt(0);
			//check overflow
			if(retVal / 10 != prev)
			{
				overflow = true;
				//check to see which value we need to return
				if(isNeg)
				{
					retVal = Integer.MIN_VALUE;
					//since we take care of the negative here, we can mark isNeg false.
					//we do not need to fix it here.
					isNeg = false;
				}
				else
				{
					retVal = Integer.MAX_VALUE;
				}
			}
			//make previous equal to current
			prev = retVal;
		}

		//check to see if we should return a negative number
		if(isNeg)
		{
			retVal *= -1;
		}
		return retVal;
	}
}
