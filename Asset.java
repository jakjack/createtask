
public class Asset {
	
	
	// private data stored within object
	private int value; 
	private String type;
	private String desc;
	// constructor
	public Asset(int v, String t, String d) {
		value = v;
		type = t;
		desc = d;
		
	}
	// access method to obtain value
	public int getValue()
	{
		return value;
	}
	// access method to obtain type
	public String getType()
	{
		return type;
	}
	
	// mutator method to revalue asset 
	public int reValue (int v)
	{
		value = v;
		return value;
	}
	// access method to obtain description
	public String getDesc()
	{
		return desc;
	}

}
