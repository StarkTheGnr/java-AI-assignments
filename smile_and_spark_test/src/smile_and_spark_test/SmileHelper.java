package smile_and_spark_test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.csv.CSVFormat;

import smile.*;
import smile.data.*;
import smile.data.measure.NominalScale;
import smile.io.*;

public class SmileHelper
{
	public DataFrame readCSV(String path)
	{
		CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
		DataFrame df = null;
		
		try
		{
			df = Read.csv(path, format);
			System.out.println(df.summary());
			
			df = df.select("name", "pclass", "age", "sex", "survived");
			System.out.println(df.summary());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
		
		return df;
	}
	
	public static int[] EncodeCategory(DataFrame df, String column)
	{
		String[] values = df.stringVector(column).distinct().toArray(new String[] {});
		int[] pClassValues = df.stringVector(column).factorize(new NominalScale(values)).toIntArray();
		
		return pClassValues;
	}
}
