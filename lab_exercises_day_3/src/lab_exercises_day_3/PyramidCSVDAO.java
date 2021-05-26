package lab_exercises_day_3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO
{
	public PyramidCSVDAO()
	{
		
	}
	
	public List<Pyramid> readPyramidsFromCSV(String fileName)
	{
		List<Pyramid> pyramids = new ArrayList<Pyramid>();
		
		try
		{
			FileReader reader = new FileReader(fileName);
			BufferedReader b_read = new BufferedReader(reader);
			
			String line = b_read.readLine();
			line = b_read.readLine();
			while (line != null)
			{
				String[] data = line.split(",");
				pyramids.add(createPyramid(data));
				
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
		
		return pyramids;
	}
	
	public Pyramid createPyramid(String[] metadata)
	{
		double height = -1;
		try
		{
			height = Double.parseDouble(metadata[7]);
		}
		catch (NumberFormatException e) { }
		
		return new Pyramid(metadata[0], metadata[2], metadata[4], height);
	}
}
