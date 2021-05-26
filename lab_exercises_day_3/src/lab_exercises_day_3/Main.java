package lab_exercises_day_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		CountryCSVDAO cdao = new CountryCSVDAO();
		List<Country> countries = cdao.readCsvFromFile("D://countries.csv");
		
		for(Country c : countries)
		{
			System.out.println(c);
		}
		
		CityCSVDAO citydao = new CityCSVDAO();
		List<City> cities = citydao.readCsvFromFile("D://cities.csv");
		
		for(City city : cities)
		{
			System.out.println(city);
		}
		
		Map<Integer, List<City>> c_cities = new HashMap<>();
		for(City city : cities)
		{
			if (c_cities.get(city.getCode()) == null)
			{
				List<City> cityList = new ArrayList<>();
				cityList.add(city);
				
				c_cities.put(city.getCode(), cityList);
			}
			else
			{
				c_cities.get(city.getCode()).add(city);
				Collections.sort(c_cities.get(city.getCode()), (a, b) -> {
					return a.getPop() - b.getPop();
				});
			}
		}
		
		System.out.println(c_cities.get(0));
		
		System.out.println(StringUtils.betterString("hi", "bye", (s1,s2) -> s1.length() > s2.length()));
		System.out.println(StringUtils.betterString("hi", "bye", (s1,s2) -> true));
		System.out.println(StringUtils.onlyAlphabets("hii#i"));
		
		System.out.println(CountryCityStreamOps.getHighestPopCityByCountry(cities, 0));
		System.out.println(CountryCityStreamOps.getHighestPopCityByContinent(cities, "Middle East"));
		System.out.println(CountryCityStreamOps.getHighestPopCapital(countries, cities));
		
		PyramidCSVDAO pdao = new PyramidCSVDAO();
		List<Pyramid> pyramids = pdao.readPyramidsFromCSV("D://pyramids.csv");
		
		System.out.println("Lower Q: " + PyramidStreamOps.getHeightLowerQ(pyramids));
		System.out.println("Median: " + PyramidStreamOps.getHeightMedian(pyramids));
		System.out.println("Upper Q: " + PyramidStreamOps.getHeightUpperQ(pyramids));
	}

}
