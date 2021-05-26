package lab_exercises_day_3;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PyramidStreamOps
{
	public static double getHeightMedian(List<Pyramid> pyramids)
	{
		List<Pyramid> pyramidsArr = pyramids.stream().sorted(Comparator.comparingDouble(p -> p.getHeight())).collect(toList());
		return getHeightMedianArr(pyramidsArr);
	}
	
	public static double getHeightLowerQ(List<Pyramid> pyramids)
	{
		List<Pyramid> pyramidsArr = pyramids.stream().sorted(Comparator.comparingDouble(p -> p.getHeight())).limit(pyramids.size()/2).collect(toList());
		return getHeightMedianArr(pyramidsArr);
	}
	
	public static double getHeightUpperQ(List<Pyramid> pyramids)
	{
		List<Pyramid> pyramidsArr = pyramids.stream().sorted(Comparator.comparingDouble(p -> -1*p.getHeight())).limit(pyramids.size()/2).collect(toList());
		return getHeightMedianArr(pyramidsArr);
	}
	
	private static double getHeightMedianArr(List<Pyramid> arr)
	{
		if(arr.size() % 2 == 0)
		{
			return (arr.get(arr.size()/2).getHeight() + arr.get(arr.size()/2 + 1).getHeight())/2;
		}
		else
		{
			return arr.get(arr.size()/2 + 1).getHeight();
		}
	}
}
