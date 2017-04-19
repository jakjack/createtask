import java.util.ArrayList;

public class User {
String firstname;
String lastname;
	private ArrayList<Transaction> income = new ArrayList<Transaction>(); 
	private ArrayList<Transaction> outgoing = new ArrayList<Transaction>();
	private ArrayList<Asset> assets = new ArrayList<Asset>();
	
	public User()
	{
		
	}
	public void addName(String fname, String lname){
		firstname = fname; 
		lastname = lname; 
	}
	public ArrayList<Transaction> get_income()
	{
		return income;
	}
	
	public ArrayList<Transaction> get_outgoing()
	{
		return outgoing;
	}
	public void printName(){
		System.out.print("" + firstname + " " + lastname+"\n");
	}
	public void printTransactions(String type, int value, String[] tags){
		
			System.out.println(type+": "+value+" Tags: "+tags[0]+", "+tags[1]+", "+tags[2]);
		
	}
	public void addTransaction(String type, int value, String[] tags)
	{
		/*if(type.equals("Incoming"))
		{
			income.add(new Transaction(value, (income.size()-1)));
			
			for(int i = 0; i < tags.length; i++)
			{
				income.get(income.size()-1).addTags(tags[i]);
			}
		}
		
		if(type.equals("Outgoing"))
		{
			outgoing.add(new Transaction(value, (outgoing.size()-1)));
			
			for(int i = 0; i < tags.length; i++)
			{
				outgoing.get(outgoing.size()-1).addTags(tags[i]);
			}
		}*/
		
		
	}
	
	public void addAsset(String type, int value, String desc)
	{
		assets.add(new Asset(value, type, desc));
	}
	
}
