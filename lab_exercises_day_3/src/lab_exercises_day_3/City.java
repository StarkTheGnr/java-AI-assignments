package lab_exercises_day_3;

public class City
{
	private String name, continent;
	private int code, pop;
	private double area;
	
	public City(String name, String cont, double area, int code, int pop)
	{
		this.name = name;
		this.continent = cont;
		this.area = area;
		this.code = code;
		this.pop = pop;
	}
	
	public int getPop()
	{
		return pop;
	}
	public void setPop(int pop)
	{
		this.pop = pop;
	}
	public double getArea()
	{
		return area;
	}
	public void setArea(double area)
	{
		this.area = area;
	}
	public int getCode()
	{
		return code;
	}
	public void setCode(int code)
	{
		this.code = code;
	}
	public String getContinent()
	{
		return continent;
	}
	public void setContinent(String continent)
	{
		this.continent = continent;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return "City Name: " + name + ", Continent: " + continent + ", Area: " + area + ", Country Code: " + code + ", Population: " + pop;
	}
}
