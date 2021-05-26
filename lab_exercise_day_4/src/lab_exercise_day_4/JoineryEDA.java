package lab_exercise_day_4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import joinery.DataFrame;

public class JoineryEDA
{
	public DataFrame<Object> readCSV(String fileName)
	{
		try
		{
			return DataFrame.readCsv(fileName);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void create2DataFrames()
	{
		DataFrame<Object> employeedf = new DataFrame<>("employeeId", "name", "age", "sex", "managerId");
		DataFrame<Object> managerdf = new DataFrame<>("managerId", "name", "age", "sex");
		
		List<Object> row = new ArrayList<>();
		row.add(0);
		row.add("Ahmed Mamdouh");
		row.add(40);
		row.add("M");
		row.add(0);
		employeedf.append(row);
		
		row = new ArrayList<>();
		row.add(1);
		row.add("Baheya Fouad");
		row.add(32);
		row.add("F");
		row.add(null);
		employeedf.append(row);
		
		row = new ArrayList<>();
		row.add(0);
		row.add("Rawan El Rawy");
		row.add(36);
		row.add("F");
		managerdf.append(row);
		
		System.out.println(employeedf);
		System.out.println(managerdf);
		
		employeedf.add("phone_number", Arrays.asList(new Object[] {"010021531", "59495461"}));
		managerdf.add("phone_number", Arrays.asList(new Object[] {"0151498"}));
		
		System.out.println(employeedf);
		System.out.println(managerdf);
		
		DataFrame<Object> emdf = employeedf.joinOn(managerdf, 4, 0);
		
		System.out.println(emdf);
	}
}
