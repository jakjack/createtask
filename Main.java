import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;




public class Main
{
	JFrame window = new JFrame();
	JPanel navbar = new JPanel();

	JButton homenav = new JButton("Home");
	JButton reportsnav = new JButton("Reports");
	JButton transactionsnav = new JButton("Transactions Log");
	JButton quickaddnav = new JButton("Quick Add");
	JButton quitnav = new JButton("Quit");

	GridLayout home = new GridLayout(3,1);
	GridLayout transactions = new GridLayout(3,1);
	GridLayout reports = new GridLayout(3,3);

	JLabel hlabel = new JLabel("Welcome to the personal finance organizer");
	JLabel worth = new JLabel("Current Total Net worth:" + calcWorth());




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
		navbar.add(quickaddnav);
		navbar.add(quitnav);
		
		

		homenav.addActionListener( new ButtonListener() );
		reportsnav.addActionListener(new ButtonListener() );
		transactionsnav.addActionListener(new ButtonListener() );
		quickaddnav.addActionListener(new ButtonListener() );
		quitnav.addActionListener(new ButtonListener() );


		if (appStatus == 0)
		{
			System.out.println("Popup suceed");
			doHomeScreen();


		}
		if (appStatus == 1)
		{
			System.out.println("Popup failed");
			window.setLayout(reports);
			window.pack();
			window.setVisible(true);


		}
		if (appStatus == 2)
		{
			System.out.println("doTransactions");
			window.setLayout(transactions);
			window.pack();
			window.setVisible(true);


		}

		if (appStatus == 3)
		{
			doTransactionAdd();
			appStatus = 1;
		}
	}

	void doTransactionAdd()
	{
		System.out.println("Popup failed");
		String[] types = {"Incoming", "Outgoing"};
		String tags[] = new String[20];
		int index = 0;


		String inputValue = JOptionPane.showInputDialog("Please input the value");

		int val = Integer.parseInt(inputValue);


		String type = (String) JOptionPane.showInputDialog(null,
				"Please Select the Type", "Type",
				JOptionPane.INFORMATION_MESSAGE, null,
				types, types[0]);
		System.out.println("Popup failed 2");

		String getTag = JOptionPane.showInputDialog("Please input any tags (fewer than 20), separated by a comma");
		System.out.println("Popup failed 3");
		for (int i = 0; i < getTag.length(); i++)
		{
			if( (int)getTag.charAt(i) == 44)
			{
				tags[index] = getTag.substring(0,i);
				System.out.println(tags[index]);
				getTag = getTag.substring(i);
				System.out.println(getTag);
				index++; i++;

			}
		}



		temporary.addTransaction(type, val, tags);
	}

	public void parse(){

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String nextUser= "break";

//		try {

			/*	br = new BufferedReader(new FileReader("/Users/kylechristopher/Desktop/Data.csv"));
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
		} */
		
	}
	private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {

			String source = e.getActionCommand();

			if(source.equals("Home"))
			{
				System.out.println("Button works 1");
				appStatus = 0;
			}
			if(source.equals("Reports"))
			{
				System.out.println("Button works 2");
				appStatus = 1;
			}

			if(source.equals("Transactions Log"))
			{
				System.out.println("Button works 3");
				appStatus = 2;
			}

			if(source.equals("Quick Add"))
			{
				System.out.println("Button works 4");
				doTransactionAdd();
			}


			if(source.equals("Quit"))
			{
				System.out.println("Button works 5");
			}


		}
	}

	public int calcWorth()
	{
		return -1;
	}
	public void doHomeScreen()
	{
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
		 ArrayList<Transaction> iDataCopy= new ArrayList<Transaction>();
		 ArrayList<Transaction> oDataCopy= new ArrayList<Transaction>();
		 iDataCopy = temporary.get_income();
		 oDataCopy = temporary.get_outgoing();
		 
		 int tableSize = iDataCopy.size() + oDataCopy.size();
		 
		 String rowData[][] = new String[tableSize][2];
		 
		String[] cnames = {"Id","Value", "Tags"};
		
		
		for(int i = 0; i < iDataCopy.size(); i++)
		{
			rowData[i][0] = Integer.toString(iDataCopy.get(i).getId());
			rowData[i][1] = Integer.toString(iDataCopy.get(i).getValue());
		}
		
		
		JTable transactionsTable = new JTable(rowData, cnames);
		JScrollPane transactionView = new JScrollPane(transactionsTable);
		transactionsTable.setFillsViewportHeight(true);
		
		transactionsnav.add(navbar);
		transactionsnav.add(transactionView);
		transactionsnav.add(worth);
		

	} 
}
