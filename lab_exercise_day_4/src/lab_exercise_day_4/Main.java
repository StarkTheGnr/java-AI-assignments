package lab_exercise_day_4;

import joinery.DataFrame;
import lab_exercise_day_4.TablesawEDA;
import tech.tablesaw.api.Table;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TablesawEDA ts = new TablesawEDA();
		Table titanic = ts.loadCSV("C:\\Users\\StarkTheGnr\\Desktop\\ITI\\Java & UML\\titanic.csv");
		
		//System.out.println(titanic);
		//System.out.println(titanic.structure());
		//System.out.println(ts.getSummary(titanic));
		
		JoineryEDA joinery = new JoineryEDA();
		DataFrame<Object> df = joinery.readCSV("C:\\Users\\StarkTheGnr\\Desktop\\ITI\\Java & UML\\titanic.csv");
		//System.out.println(df.retain("pclass", "survived", "fare", "sex", "age").describe());
		
		//joinery.create2DataFrames();
		ts.create2DataFrames();
	}

}

