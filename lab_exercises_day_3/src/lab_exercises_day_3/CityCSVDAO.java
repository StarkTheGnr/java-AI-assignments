package lab_exercises_day_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityCSVDAO
{
	public List<City> readCsvFromFile(String fileName)
	{
		List<City> cities = new ArrayList<>();
		
		try
		{
			FileReader reader = new FileReader(fileName);
			BufferedReader b_read = new BufferedReader(reader);
			
			String line = b_read.readLine();
			line = b_read.readLine();
			while (line != null)
			{
				String[] data = line.split(",");
				cities.add(createCity(data));
				
				line = b_read.readLine();
			}
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cities;
	}
	
	public City createCity(String[] metadata)
	{
		return new City(metadata[0], metadata[1], Double.parseDouble(metadata[2]), Integer.parseInt(metadata[3]), Integer.parseInt(metadata[4]));
	}
}
