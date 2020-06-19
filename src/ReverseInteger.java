import java.util.ArrayList;

public class ReverseInteger {
	
	public static void main(String[] args)
	{
		ReverseInteger reverseInteger = new ReverseInteger();
		long num = 1534236469;
		System.out.println(reverseInteger.reverse(num));
	}
	
	public int reverse(long x)
	{
		//check to see if negative
		boolean negative = false;
		//change to be positive
		//will re add the negative at the end
		if(x <= 0)
		{
			negative = true;
			x *= -1;
		}
		//variables to keep track of things
		int reversed = 0;
		int previous = 0;
		//if overflow occurs we set this to true
		boolean overflow = false;
		while(x > 0 && !overflow)
		{
			//save previous value to compare to see if there has been overflow
			previous = reversed;
			
			//multiply by 10 to give it another digit to add too
			reversed *= 10;
			//add the lowest digit of x
			reversed += x % 10;
			//remove the low digit
			x = x / 10;
			
			//to detect overflow, check to see if the new reversed value / 10 is the same as the previous value
			if((reversed / 10)  != previous)
			{
				//overflow has happened!
				reversed = 0;
				overflow = true;
			}
		}
		
		//add back in the negative
		if(!overflow && negative)
			reversed *= -1;
		
		return reversed;
	}
}
