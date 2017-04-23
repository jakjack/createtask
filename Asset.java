
public class Asset {

	private int value; 
	private String type;
	private String desc;
	
	public Asset(int v, String t, String d) {
		value = v;
		type = t;
		desc = d;
		
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getType()
	{
		return type;
	}
	
	
	public int reValue (int v)
	{
		value = v;
		return value;
	}
	
	public String getDesc()
	{
		return desc;
	}

}
