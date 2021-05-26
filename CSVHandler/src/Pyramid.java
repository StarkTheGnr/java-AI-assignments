
public class Pyramid
{
	private double height;
	private String pharaoh, modern_name, site;
	
	public Pyramid(String pharaoh, String modern_name, String site, double height)
	{
		this.height = height;
		this.pharaoh = pharaoh;
		this.modern_name = modern_name;
		this.site = site;
	}
	
	public double getHeight()
	{
		return height;
	}
	public String getPharaoh()
	{
		return pharaoh;
	}
	public String getModernName()
	{
		return modern_name;
	}
	public String getSite()
	{
		return site;
	}
	
	public void setHeight(double new_height)
	{
		height = new_height;
	}
	public void setPharaoh(String new_pharaoh)
	{
		pharaoh = new_pharaoh;
	}
	public void setModernName(String new_name)
	{
		modern_name = new_name;
	}
	public void setSite(String new_site)
	{
		site = new_site;
	}
	
	public String toString()
	{
		return "Pharaoh: " + pharaoh + ", Modern Name: " + modern_name + ", Site: " + site + ", Height: " + Double.toString(height);
	}
}
