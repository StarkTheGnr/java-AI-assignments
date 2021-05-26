package lab_exercises_day_3;

import java.util.function.BiPredicate;

public class StringUtils
{
	public static String betterString(String s1, String s2, BiPredicate<String, String> p)
	{
		if(p.test(s1, s2))
			return s1;
		else
			return s2;
	}
	
	public static boolean onlyAlphabets(String s1)
	{
		for(int i = 0; i < s1.length(); i++)
		{
			if(!Character.isLetter(s1.charAt(i)))
				return false;
		}
		
		return true;
	}
}
