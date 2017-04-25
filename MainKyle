import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.io.*;
import java.util.Scanner;


public class Main{
	
	Scanner keyboardInput = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();

	}
	
	public Main()
	{
		//Opening instructions
		int option = 0;
		System.out.println("Welcome to Your Family Finance Manager!!!!");
		System.out.println("Please select an option\n________________\n\nEnter:\n1 View Transactions\n2 Enter New Transaction");
		
		//Loop makes sure either option 1 or 2 is chosen
		while(!(option==1||option==2)){
		option = keyboardInput.nextInt(); 	
		if(!(option==1||option==2)){
			System.out.println("Please enter a valid selection.");
		}
		}
		//If option 1 is selected, gather the user's name and run parse()
		if(option==1){
			System.out.print("Enter your last name.\n");
			String name = keyboardInput.next();
			System.out.print("Enter your first name.\n");
			String fname = keyboardInput.next();
			parse(name,fname);
		}
		//If option 2 is selected, take the users information and run writeToFile()
		if(option==2){
			System.out.print("Enter your last name.\n");
			String Lname = keyboardInput.next();
			System.out.print("Enter your first name.\n");
			String Fname = keyboardInput.next();
			System.out.println("Select a type of transaction.\n1 Incoming\n2 Outgoing");
			
			int option2 =0;
			//loop makes sure either option 1 or 2 is selected
			//1 = incoming, 2 = outgoing
			while(!(option2 == 1 || option2 == 2)){
				option2 = keyboardInput.nextInt(); 	
				if(!(option2 == 1 || option2 == 2)){
					System.out.println("Please enter a valid selection.");
				}
			}
			System.out.println("Please enter the amount of the transaction (in dollars).");
			String value = keyboardInput.next();
			System.out.println("Please enter three (3) tags");
			String tag1 = keyboardInput.next();
			String tag2 = keyboardInput.next();
			String tag3 = keyboardInput.next();
			if(option2 == 1){
			writeToFile(Lname,Fname,"in",value,tag1,tag2,tag3);
			System.out.println("Transaction added!");
			}
			if(option2 == 2){
				writeToFile(Lname,Fname,"out",value,tag1,tag2,tag3);
				System.out.println("Transaction added!");
				}
		
	
		}
		
		

		
		
		
	}
	public void writeToFile(String Lname, String Fname, String type, String amount, String tag1, String tag2, String tag3 ){
		
			FileWriter writer;
			try {
				//filepath to csv file
				writer = new FileWriter("/Users/kylechristopher/Desktop/Data.csv",true);
				
				//
				writer.append("name");
				writer.append(",");
				writer.append(Lname);
				writer.append(",");
				writer.append(Fname);
				writer.append(",");
				writer.append(type);
				writer.append(",");
				writer.append(amount);
				writer.append(",");
				writer.append(tag1);
				writer.append(",");
				writer.append(tag2);
				writer.append(",");
				writer.append(tag3);
				writer.append(",");
				writer.append("end");
				writer.append(",");
				//writer.flush();
		        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			
		
	
	}
	//parse method takes a first name and last name and prints out the transactions of that user
	public int parse(String name, String fname){
			 
		      BufferedReader br = null;
		      String line = "";
		      //commas separate values in the csv
		      String cvsSplitBy = ",";
		      

		      try {
		    	  //file path to the csv (it is on my desktop)																																																																																																																																																																																																																																																																																																																																																																																																																																	
		          br = new BufferedReader(new FileReader("/Users/kylechristopher/Desktop/Data.csv"));
		          while ((line = br.readLine()) != null) {

		             //values in csv put in array (listusers)
		        	  String[] listusers = line.split(cvsSplitBy);
		        	  User person = new User();
		        	  
		        	  //Prints out the input name
		        	  System.out.println("USER:" + fname + " " + name);
		        	  
		        	  //go through each element in listusers
		        	  for(int i = 0; i < listusers.length; i++){
		        		  //checks to make sure the spot currently in the array is the marker "name"
		        		  //and that the next spot matches with the names entered by the user
		        		  if(listusers[i].equals("name") && listusers[i + 1].equals(name) && listusers[i + 2].equals(fname)){
		        			  person.addName(listusers[i + 1], listusers[i + 2]);
		        			  
		        			  int z = i;
		        			  //"end" marks the end of the user
		        			  while(!(listusers[z].equals("end"))){
		        			  
		        			  if(listusers[z].equals("in")){
		        			  //must have 3 tags
		        				  String[] tags = new String[3];
		        				  int counter = 0; 
		        				  	for(int k = z + 2; k < z + 5; k++){
		        				  
		        				  		tags[counter]= listusers[k];
		        				  		counter++;
		        				  	}
		        				  	//changes the values from string to ints
		        				  	int result = Integer.parseInt(listusers[z + 1]);
		        				  	
		        				  	person.printTransactions("Incoming", result, tags);
		        				  	
		        		  }
		        		  
		        		  if(listusers[z].equals("out")){
		        			  //must have 3 tags
		        			  String[] tags = new String[3];
		        			  int counter = 0; 
		        			  for(int k = z + 2; k < z + 5; k++){
		        				  
		        				  tags[counter]= listusers[k];
		        				  counter++;
		        			  }
		        			  int result = Integer.parseInt(listusers[z+1]);
		        			  
		        			  person.printTransactions("Outgoing", result, tags);
		        		  }
		        		  z++;
		        			  }
		        			  
		        		  }
		        		  
		 
		        		 
		        	  }
		        	  
		        	  return 0; 
		           

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
		      System.out.println("You are not a registered user.");
			return -1;
		      }
	
}
		
