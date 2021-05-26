package lab_exercise_day_4;

import java.io.IOException;

import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class TablesawEDA
{
	public Table loadCSV(String fileName)
	{
		try
		{
			return Table.read().csv(fileName);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getSummary(Table data)
	{
		return data.summary().toString();
	}
	
	public void create2DataFrames()
	{
		
		Table employeetb = Table.create("Employee").addColumns(
				IntColumn.create("employeeId", new int[] {0, 1}), 
				StringColumn.create("name", new String[] {"Ahmed Mamdouh", "Baheya Fouad"}),
				IntColumn.create("age", new int[] {40, 32}),
				StringColumn.create("sex", new String[] {"M", "F"}),
				IntColumn.create("managerId", new int[] {0, -1}));
		Table managertb = Table.create("Manager").addColumns(
				IntColumn.create("managerId", new int[] {0}), 
				StringColumn.create("m_name", new String[] {"Rawan El Rawy"}),
				IntColumn.create("m_age", new int[] {36}),
				StringColumn.create("m_sex", new String[] {"F"}));
		
		System.out.println(employeetb);
		System.out.println(managertb);
		
		employeetb.addColumns(StringColumn.create("phone_number", new String[] {"0120010", "1283010"}));
		managertb.addColumns(StringColumn.create("m_phone_number", new String[] {"1231232"}));
		
		System.out.println(employeetb);
		System.out.println(managertb);
		
		Table emtb = employeetb.joinOn("managerId").leftOuter(managertb);
		
		System.out.println(emtb);
	}
	
}
