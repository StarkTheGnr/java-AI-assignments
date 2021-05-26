package lab_exercises_day_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryCSVDAO
{
	public List<Country> readCsvFromFile(String fileName)
	{
		List<Country> countries = new ArrayList<>();
		
		try
		{
			FileReader reader = new FileReader(fileName);
			BufferedReader b_read = new BufferedReader(reader);
			
			String line = b_read.readLine();
			line = b_read.readLine();
			while (line != null)
			{
				String[] data = line.split(",");
				countries.add(createCountry(data));
				
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
		
		return countries;
	}
	
	public Country createCountry(String[] metadata)
	{
		return new Country(Integer.parseInt(metadata[0]), metadata[1], metadata[2], Double.parseDouble(metadata[3]), metadata[4]);
	}
}
