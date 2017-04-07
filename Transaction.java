import java.util.ArrayList;

public class Transaction {

	 private int value;
	 private int id;
	 private ArrayList<String> tags;
	 
	 
	 public Transaction(int v, int i)
	 {
		 value = v;
		 id = i;
	 }
	 
	public void addTags(String t)
	 {
		 tags.add(t);
		 
	 }
	 
	 public int getValue()
	 {
		 return value;
	 }
	 
	 public int reValue(int i)
	 {
		 value = i;
		 return value;
	 }
	 
	 public ArrayList<String> getTags()
	 {
		 return tags; 
	 }
	 
	 public int getId()
	 {
		 return id;
		 
	 }

}

