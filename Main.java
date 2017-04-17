import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;



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
		
		homenav.addActionListener(new ButtonListener() );
		reportsnav.addActionListener(new ButtonListener() );
		transactionsnav.addActionListener(new ButtonListener() );
		quitnav.addActionListener(new ButtonListener() );
		
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
	
	
	private class ButtonListener implements ActionListener
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
			
			for (int i = 0; i < getTag.length(); i++)
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
