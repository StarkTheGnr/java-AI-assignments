
package smile_and_spark_test;

import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;

import smile.data.DataFrame;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SmileHelper sh = new SmileHelper();
		
		DataFrame data = sh.readCSV("C:\\Users\\StarkTheGnr\\Desktop\\ITI\\Java & UML\\titanic.csv");
		System.out.println(data.summary());
		
		
		YoutubeTitleWordCount ytwc = new YoutubeTitleWordCount();
		JavaRDD<String> data2 = ytwc.readData("C:\\Users\\StarkTheGnr\\Desktop\\ITI\\Java & UML\\USvideos.csv");
		data2 = ytwc.applyTransformation(data2);
		List<Map.Entry> wordcounts = ytwc.CountWords(data2);
		
		for(Map.Entry<String, Long> entry : wordcounts)
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
