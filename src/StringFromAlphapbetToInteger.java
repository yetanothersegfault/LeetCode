public class StringFromAlphapbetToInteger {
	
	public static void main(String[] args)
	{
		String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
		StringFromAlphapbetToInteger sol = new StringFromAlphapbetToInteger();
		System.out.println(sol.freqAlphabets(s));
	}
	
	public String freqAlphabets(String s)
	{
		StringBuilder ans = new StringBuilder();
		while(s.length() > 0)
		{
			char ch;
			try
			{
				ch = s.charAt(2);
			}
			catch(Exception e)
			{
				//we have almost reached the end of the string but there is still single digit values left
				ch = '1';
			}

			String sub = "";
			if(ch == 35)
			{
				//means we have a two digit number
				//grab the two digit number
				sub = s.substring(0, 2);
				//get rid of value
				s = s.substring(3);
			}
			else
			{
				//we have a single digit number
				sub = s.substring(0, 1);
				//remove value from string
				s = s.substring(1);
			}
			//convert it to an int, add 96 and cast to char and append with ans
			ans.append((char)(Integer.parseInt(sub) + 96));
		}
		return ans.toString();
	}
}
