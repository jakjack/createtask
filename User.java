import java.util.ArrayList;

public class User {
	// data stored within user object
	String firstname;
	String lastname;
	private ArrayList<Transaction> income = new ArrayList<Transaction>(); 
	private ArrayList<Transaction> outgoing = new ArrayList<Transaction>();
	private ArrayList<Asset> assets = new ArrayList<Asset>();

	// constructor 
	public User()
	{
		
	}
	// mutator method for firstname and lastnames
	public void addName(String fname, String lname){
		firstname = fname; 
		lastname = lname; 
	}
	
	
	// get method for private ArrayList income
	public ArrayList<Transaction> get_income()
	{
		return income;
	}
	// get method for private ArrayList outgoing
	public ArrayList<Transaction> get_outgoing()
	{
		return outgoing;
	}
	
	
	// mutator method for both private ArrayLists, adds transaction objects based on params
	public void addTransaction(String type, int value, String[] tags)
	{
		// parses type, then adds the various values to the transaction object
		if(type.equals("Incoming"))
		{
			income.add(new Transaction(value, (income.size()+1)));

			if(tags != null)
			{
				for(int i = 0; i < tags.length; i++)
				{
					income.get(income.size()-1).addTags(tags[i]);
				}
			}
			else return;
		}

		if(type.equals("Outgoing"))
		{
			outgoing.add(new Transaction(value, (outgoing.size()+1)));

			if(tags != null)
			{
				for(int i = 0; i < tags.length; i++)

				{
					outgoing.get(outgoing.size()-1).addTags(tags[i]);
				}
			}
			else return;
		}


	}
	
	// adds a new asset based off of parameters supplied 
	
	public void addAsset(String type, int value, String desc)
	{
		assets.add(new Asset(value, type, desc));
	}


	
	// calculates the given worth of the user through an algorithm
	
	public int getWorth()
	{
		int worth = 0;
		
		for(int i = 0; i < income.size(); i++)
		{
			worth += income.get(i).getValue();
		}
		for(int j = 0; j < outgoing.size(); j++)
		{
			worth -= outgoing.get(j).getValue();
		}
		
		for(int k = 0; k < assets.size(); k++)
		{
			worth += assets.get(k).getValue();
		}
		// returns for use in the main class
		return worth;
	}
}


