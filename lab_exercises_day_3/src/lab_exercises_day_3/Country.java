package lab_exercises_day_3;

public class Country
{
	private String name, continent, capital;
	private double area;
	private int code;
	
	public Country(int code, String name, String cont, double area, String capital)
	{
		this.setCode(code);
		this.name = name;
		this.continent = cont;
		this.area = area;
		this.capital = capital;
	}
	
	public double getArea()
	{
		return area;
	}
	public void setArea(double area)
	{
		this.area = area;
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
	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getCapital()
	{
		return capital;
	}

	public void setCapital(String capital)
	{
		this.capital = capital;
	}
	
	public String toString()
	{
		return "Code: " + code + ", Country Name: " + name + ", Continent: " + continent + ", Area: " + area + ", Capital: " + capital;
	}
}
