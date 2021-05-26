package smile_and_spark_test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class YoutubeTitleWordCount
{
	public JavaRDD<String> readData(String path)
	{
		Logger.getLogger("org").setLevel(Level.ERROR);
		
		SparkConf conf = new SparkConf().setAppName("wordCounts").setMaster("local[3]");
		JavaSparkContext sparkContext = new JavaSparkContext(conf);
		
		JavaRDD<String> videos = sparkContext.textFile(path);
		
		return videos;
	}
	
	public JavaRDD<String> applyTransformation(JavaRDD<String> data)
	{
		JavaRDD<String> output = data.map(YoutubeTitleWordCount::extractTitle).filter(StringUtils::isNotBlank);
		
		output = output.flatMap(in -> Arrays.asList(in.toLowerCase().trim().replaceAll("\\p{Punct}", "").split(" ")).iterator());
		
		return output;
	}
	
	public List<Map.Entry> CountWords(JavaRDD<String> words)
	{
		Map<String, Long> wordCounts = words.countByValue();
		List<Map.Entry> sorted = wordCounts.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
		
		return sorted;
	}
	
	public static String extractTitle(String videoLine)
	{
		try
		{
			return videoLine.split(",")[2];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return "";
		}
	}
}
