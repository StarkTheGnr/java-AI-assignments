package lab_exercises_day_3;

import java.util.List;

public class CountryCityStreamOps
{
	public static City getHighestPopCityByCountry(List<City> cities, int countryCode)
	{
		return cities.stream().filter((c) -> (c.getCode() == countryCode)).max((c1, c2) -> (c1.getPop() - c2.getPop())).get();
	}
	
	public static City getHighestPopCityByContinent(List<City> cities, String continent)
	{
		return cities.stream().filter((c) -> (c.getContinent().equals(continent))).max((c1, c2) -> (c1.getPop() - c2.getPop())).get();
	}
	
	public static City getHighestPopCapital(List<Country> countries, List<City> cities)
	{
		return cities.stream().filter((city) -> {
			for(Country country : countries)
			{
				if(city.getName().equals(country.getCapital()))
					return true;
			}
			
			return false;
		}).max((c1, c2) -> (c1.getPop() - c2.getPop())).get();
	}
}
