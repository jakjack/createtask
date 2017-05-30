//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
// main class
public class Main
{
	// window constants declaration
	final int WINDOW_WIDTH = 800;
	final int WINDOW_HEIGHT = 800;

	User person = new User();
	// Main window initiation
	JFrame window = new JFrame();
	// declaration of menubar panel
	JPanel navbar = new JPanel();
	//button declaration
	JButton homenav = new JButton("Home");
	JButton transactionsnav = new JButton("Transactions Log");
	JButton quickaddnav = new JButton("Quick Add");
	JButton quitnav = new JButton("Quit");
	// layout pane declarations
	GridLayout home = new GridLayout(3,1);
	GridLayout transactions = new GridLayout(3,1);
	// label declarations
	JLabel hlabel = new JLabel("Welcome to the personal finance organizer");
	JLabel worth = new JLabel("Current Total Net worth: " + calcWorth());


	// run to boot program
	public static void main(String[] args) {
		@SuppressWarnings(value = { "unused" }) 
		Main main = new Main();

	}
	// main class
	public Main()
	{
		// creates main window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// adds buttons to navbar panel 
		navbar.add(homenav);
		navbar.add(transactionsnav);
		navbar.add(quickaddnav);
		navbar.add(quitnav);
		// add ButtonListeners to buttons
		homenav.addActionListener( new ButtonListener() );
		transactionsnav.addActionListener(new ButtonListener() );
		quickaddnav.addActionListener(new ButtonListener() );
		quitnav.addActionListener(new ButtonListener() );

		// render the main home screen 
		parse();
		doHomeScreen();



	}
	// run on transaction add
	void doTransactionAdd()
	{
		// create string options for later use
		String[] types = {"Incoming", "Outgoing"};
		// empty array for later use;
		String tags[] = new String[3];

		int index = 0;

		// get the value of the transaction from the user
		String inputValue = JOptionPane.showInputDialog("Please input the value");

		int val = Integer.parseInt(inputValue);

		// get the type of transaction from the user by dropdown menu
		String type = (String) JOptionPane.showInputDialog(null,
				"Please Select the Type", "Type",
				JOptionPane.INFORMATION_MESSAGE, null,
				types, types[0]);

		// get any and all tags from the user
		String getTag = JOptionPane.showInputDialog("Please input any 3 tags separated by a comma");
		//parse tags

		for (int i = 0; i < getTag.length(); i++)
		{
			if( (int)getTag.charAt(i) == 44)
			{
				tags[index] = getTag.substring(0,i);
				getTag = getTag.substring(i+1);				
				index++;

			}
			
			else tags[2] = getTag;
			
		}


		// add transactions to user
		person.addTransaction(type, val, tags);
	}
	// begin partner code 
	public void parse(){

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		@SuppressWarnings(value = { "unused" })
		String nextUser= "break";

		try {

			br = new BufferedReader(new FileReader("/Users/pjpujadas/Documents/Data.csv"));
			while ((line = br.readLine()) != null) {

				// use comma as separator

				String[] listusers = line.split(cvsSplitBy);

				for(int i = 0; i < listusers.length; i++){

					if(listusers[i].equals("name")){
						person.addName(listusers[i+1], listusers[i+2]);
						
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
						
					}

				}


			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
	// end partner code


	// button listener sub-class for button listening
	private class ButtonListener implements ActionListener
	{
		// when a button is clicked, this method runs
		public void actionPerformed(ActionEvent e) {
			// parses button source and runs subsequent statement based on action
			String source = e.getActionCommand();

			if(source.equals("Home"))
			{
				// refreshes or redirects to home screen 
				doHomeScreen();
			}
			if(source.equals("Transactions Log"))
			{
				// creates transaction popup and moves over navbar
				doTable();
			}

			if(source.equals("Quick Add"))
			{
				// runs quickadd popup to add more transactions
				doTransactionAdd();

			}


			if(source.equals("Quit"))
			{
				// runs output code to write to file and saves the data, then quits
				doFilePrint();
				System.exit(0);
			}


		}
	}

	public int calcWorth()
	{
		// calculates the worth of the user for use in labels 
		return person.getWorth();

	}
	public void doHomeScreen()
	{
		// sets layout, updates labels, and renders the homescreen window on call
		worth.setText("Current Total Net worth: " + calcWorth());
		window.setLayout(home);
		window.add(navbar);
		hlabel.updateUI();
		window.add(hlabel);
		worth.updateUI();
		window.add(worth);
		window.pack();
		window.setVisible(true);
	}


	public void doTable()
	{

		// parses data from the user, renders it into a JTable, and displays as a scrollable object


		// new popout window
		JFrame tableWin = new JFrame();

		tableWin.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		ArrayList<Transaction> iDataCopy= new ArrayList<Transaction>();
		ArrayList<Transaction> oDataCopy= new ArrayList<Transaction>();
		iDataCopy = person.get_income();
		oDataCopy = person.get_outgoing();

		int tableSize = iDataCopy.size() + oDataCopy.size();

		String rowData[][] = new String[tableSize][3];

		String[] cnames = {"Id","Value", "Tags"};

		// data parsing
		for(int i = 0; i < iDataCopy.size(); i++)
		{
			rowData[i][0] = Integer.toString(iDataCopy.get(i).getId());
			rowData[i][1] = Integer.toString(iDataCopy.get(i).getValue());		
			rowData[i][2] = iDataCopy.get(i).getTags();
		}

		for(int j = 0; j < oDataCopy.size(); j++)
		{
			rowData[j+iDataCopy.size()][0] = Integer.toString(oDataCopy.get(j).getId());
			rowData[j+iDataCopy.size()][1] = (Integer.toString(-(oDataCopy.get(j).getValue())));		
			rowData[j+iDataCopy.size()][2] = oDataCopy.get(j).getTags();
		}




		JTable transactionsTable = new JTable(rowData, cnames);
		JScrollPane transactionView = new JScrollPane(transactionsTable);
		transactionsTable.setFillsViewportHeight(true);
		tableWin.setLayout(transactions);
		tableWin.add(navbar);
		tableWin.add(transactionView);
		tableWin.add(worth);
		tableWin.pack();
		tableWin.setVisible(true);


	} 
	// runs on exit and prints the data to be saved to a CSV file 
	// return exit code 0
	int doFilePrint()
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		String write = "";
		
		ArrayList<Transaction> iDataCopy= new ArrayList<Transaction>();
		ArrayList<Transaction> oDataCopy= new ArrayList<Transaction>();
		iDataCopy = person.get_income();
		oDataCopy = person.get_outgoing();
		
		for(int i = 0; i < iDataCopy.size(); i++)
		{
			write += person.firstname;
			write += ",";
			write += person.lastname;
			write += ",";
			write += "in";
			write += ",";
			write += Integer.toString(iDataCopy.get(i).getValue());
			write += ",";
			write += iDataCopy.get(i).getTags();
			write += ",";
			
		}
		
		for(int i = 0; i < oDataCopy.size(); i++)
		{
			write += person.firstname;
			write += ",";
			write += person.lastname;
			write += ",";
			write += "out";
			write += ",";
			write += Integer.toString(oDataCopy.get(i).getValue());
			write += ",";
			write += oDataCopy.get(i).getTags();
			write += ",";
			
		}
		try {
			fw = new FileWriter("/Users/pjpujadas/Documents/Data.csv");
			bw = new BufferedWriter(fw);		
			bw.write(write);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
					return 0;
				}

			}
		}
		return 0;
	}
}
