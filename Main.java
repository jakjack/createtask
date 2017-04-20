import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.io.*;



public class Main{
	JFrame window = new JFrame();
	JPanel navbar = new JPanel();
	
	JButton homenav = new JButton("Home");
	JButton reportsnav = new JButton("Reports");
	JButton transactionsnav = new JButton("Transactions");
	JButton quickaddnav = new JButton("Quick Add");
	JButton quitnav = new JButton("quit");
	
	GridLayout home = new GridLayout(2,1);
	GridLayout transactions = new GridLayout(2,3);
	GridLayout reports = new GridLayout(3,3);
	int appStatus = 0;
	
	User temporary = new User();
	
	public static void main(String[] args) {
		Main main = new Main();

	}
	
	public Main()
	{
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		navbar.add(homenav);
		navbar.add(reportsnav);
		navbar.add(transactionsnav);
		navbar.add(quitnav);
		
		/*homenav.addActionListener(new ButtonListener() );
		reportsnav.addActionListener(new ButtonListener() );
		transactionsnav.addActionListener(new ButtonListener() );
		quitnav.addActionListener(new ButtonListener() );*/
		parse();
		while(true)
		{
			if (appStatus == 0)
			{
				
				window.add(navbar);
				window.pack();
				window.setVisible(true);
				

			}
			if (appStatus == 1)
			{
				
				window.setLayout(transactions);
				window.pack();
				window.setVisible(true);
				

			}
			if (appStatus == 2)
			{
				
				window.setLayout(reports);
				window.pack();
				window.setVisible(true);
				

			}
		}

		
		
		
	}
	
	public void parse(){
			 
		      BufferedReader br = null;
		      String line = "";
		      String cvsSplitBy = ",";
		      String nextUser= "break";

		      try {
		    	  																																																																																																																																																																																																																																																																																																																																																																																																																																	
		          br = new BufferedReader(new FileReader("/Users/kylechristopher/Desktop/Data.csv"));
		          while ((line = br.readLine()) != null) {

		              // use comma as separator
		        	  
		        	  String[] listusers = line.split(cvsSplitBy);
		        	  User person = new User();
		        	  
		        	  for(int i = 0; i < listusers.length; i++){
		        		  
		        		  if(listusers[i].equals("name")){
		        			  person.addName(listusers[i+1], listusers[i+2]);
		        			  person.printName();
		        		  }
		        		  if(listusers[i].equals("in")){
		        			  //must have 3 tags
		        			  String[] tags = new String[3];
		        			  int counter = 0; 
		        			  for(int k = i + 2; k < i + 5; k++){
		        				  
		        				  tags[counter]= listusers[k];
		        				  counter++;
		        			  }
		        			  int result = Integer.parseInt(listusers[i+1]);
		        			  person.addTransaction("Incoming", result, tags);
		        			  person.printTransactions("Incoming", result, tags);
		        		  }
		        		  if(listusers[i].equals("out")){
		        			  //must have 3 tags
		        			  String[] tags = new String[3];
		        			  int counter = 0; 
		        			  for(int k = i + 2; k < i + 5; k++){
		        				  
		        				  tags[counter]= listusers[k];
		        				  counter++;
		        			  }
		        			  int result = Integer.parseInt(listusers[i+1]);
		        			  person.addTransaction("Outgoing", result, tags);
		        			  person.printTransactions("Outgoing", result, tags);
		        		  }
		        		 // if()
		        	  //}
		              //User user = new User("test");
		        	  }
		              //System.out.println("User Created");
		              //person.printName();
		              //System.out.println(listusers[1]);

		          }

		      } catch (FileNotFoundException e) {
		          e.printStackTrace();
		          //makeUser();
		      } catch (IOException e) {
		          e.printStackTrace();
		      } finally {
		          if (br != null) {
		              try {
		                  br.close();
		              } catch (IOException e) {
		                  e.printStackTrace();
		              }
		          }
		      }
		      }
	/*private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			
			String source = e.getActionCommand();
			
			if(source.equals("Home"))
			{
				appStatus = 0;
			}
			if(source.equals("Reports"))
			{
				appStatus = 1;
			}
			
			if(source.equals("Transactions"))
			{
				appStatus = 2;
			}
			
			if(source.equals("Quick Add"))
			{
				String[] types = {"Incoming", "Outgoing"};
				String tags[] = new String[20];
				
				
				String inputValue = JOptionPane.showInputDialog("Please input the value");
				int val = Integer.parseInt(inputValue);
				
				
				String type = (String) JOptionPane.showInputDialog(null,
			             "Please Select the Type", "Type",
			             JOptionPane.INFORMATION_MESSAGE, null,
			             types, types[0]);
				
				String getTag = JOptionPane.showInputDialog("Please input any tags, separated by a comma");
			}
			
			/*for (int i = 0; i < getTag.length(); i++)
			{
				if( (int)charAt(i) == 44)
				{
					
					
				}
				
				
				
	
				temporary.addTransaction();
			}
			
			
			if(source.equals("Quit"))
			{
				
			}
			
			
		}
		
	}

}
	}*/
}
		

