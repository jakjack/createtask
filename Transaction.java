import java.util.ArrayList;

public class Transaction {
	
	
	// data stored within object
	 private int value;
	 private int id;
	 private ArrayList<String> tags = new ArrayList<String>();
	 
	 // constructor to create the base object with no tags
	 public Transaction(int v, int i)
	 {
		 value = v;
		 id = i;
	 }
	 // mutator method adding tags to object via parameters 
	public void addTags(String t)
	 {

		 tags.add(t);
		 
	 }
	 // access method to get value data 
	 public int getValue()
	 {
		 return value;
	 }
	 // mutator method to re-value the transaction 
	 public int reValue(int i)
	 {
		 value = i;
		 return value;
	 }
	 // access method to get the tags as a single sting out of an ArrayList
	 public String getTags()
	 {
		 String t = "";
		 
		 for(int i = 0; i < tags.size(); i++)
		 {
			 if(i != 0)
			 {
			 t += " , ";
			 }
			 t += tags.get(i);
		 }
		 return t;
	 }
	 
	 // access method to get a transaction id
	 public int getId()
	 {
		 return id;
		 
	 }

}

