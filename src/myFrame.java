import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame extends JFrame implements ActionListener{
	
    JTextField txtfrom, txtto;
    JButton Convert, Clear;
    JComboBox<String> c1, c2;
    JLabel lblfrom, lblto;

    myFrame() {
        // Frame setup
        this.setTitle("Currency Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null); // Center the frame on the screen

        
        // Set icon image
        ImageIcon icon = new ImageIcon("C:\\Users\\Levin\\Downloads\\6c2d40e51b303afa827ba31f73b48223.jpg");  // Replace with the path to your icon image
        setIconImage(icon.getImage());
        
        //Panels for GUI
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Labels
        lblfrom = new JLabel("From Currency: ");
        lblto = new JLabel("To Currency");

        // Text fields
        txtfrom = new JTextField();
        txtto = new JTextField();

        // Currency array
        String[] currency = {"INR", "USD", "GBP", "YEN", "WON", "Riyal", "Euro"};

        // Dropdown menus
        c1 = new JComboBox<>(currency);
        c2 = new JComboBox<>(currency);

        // Set preferred size for text fields
        txtfrom.setPreferredSize(new Dimension(150, 10));
        txtto.setPreferredSize(new Dimension(150, 10));
        
        // Set preferred size for JComboBox components
        c1.setPreferredSize(new Dimension(150, 30));
        c2.setPreferredSize(new Dimension(150, 30));
        
        // Add components to inputPanel
        inputPanel.add(lblfrom);
        inputPanel.add(txtfrom);
        inputPanel.add(lblto);
        inputPanel.add(txtto);
        inputPanel.add(c1);
        inputPanel.add(c2);

        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        
        // Buttons
        Convert = new JButton("Convert");
        Clear = new JButton("Clear");
        
        // Add buttons to buttonPanel
        buttonPanel.add(Convert);
        buttonPanel.add(Clear);

        // Add action listeners
        c1.addActionListener(this);
        c2.addActionListener(this);
        Convert.addActionListener(this);
        Clear.addActionListener(this);
        
        // Add inputPanel and buttonPanel to the frame
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        this.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Convert) {
			String amount = txtfrom.getText();
			String cash1 = (String) c1.getSelectedItem();
			String cash2 = (String) c2.getSelectedItem();
			
			// Check if both currencies are selected
	        if (cash1 == null || cash2 == null) {
	            JOptionPane.showMessageDialog(null, "Please select both currencies.");
	            return;
	        }
			
	        // Check if the amount is empty
	        if (amount.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please enter an amount.");
	            return;
	        }
	        
			//to catch invalid input (while there is input it converts it to double datatype)
			if (!amount.isEmpty()) {
	            try {
	                double Amount = Double.parseDouble(amount);
	                double result = convertCurrency(Amount, cash1, cash2);
	                txtto.setText(String.valueOf(result));
	            } catch (NumberFormatException ex) {
	                // Handle invalid input (non-numeric)
	                txtto.setText("Invalid input");
	            }
	        }
		}
		else if (e.getSource() == Clear) {
			txtfrom.setText("");
			txtto.setText("");
		}
	}

	private double convertCurrency(double Amount, String cash1, String cash2) {
		// TODO Auto-generated method stub
		//Implement nested switch statement  for conversion logic
		switch(cash1) {
		//conversion from INR to different currency
		case "INR":
			switch(cash2) {
			case "INR":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 0.012;
				break;
			case "GBP":
				Amount= Amount * 0.0094;
				break;
			case "YEN":
				Amount= Amount * 1.77;
				break;
			case "WON":
				Amount= Amount * 16.01;
				break;
			case "Riyal":
				Amount= Amount * 0.045;
				break;
			case "Euro":
				Amount = Amount * 0.011;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
			
		//conversion from USD to different currency	
		case "USD":
			switch(cash2) {
			case "USD":
				Amount= Amount * 1;
				break;
			case "INR":
				Amount= Amount * 83.11;
				break;
			case "GBP":
				Amount= Amount * 0.78;
				break;
			case "YEN":
				Amount= Amount * 147.19;
				break;
			case "WON":
				Amount= Amount * 1330.41;
				break;
			case "Riyal":
				Amount= Amount * 3.75;
				break;
			case "Euro":
				Amount= Amount * 0.92;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
		
		//conversion from GBP to different currency	
		case "GBP":
			switch(cash2) {
			case "GBP":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 1.27;
				break;
			case "INR":
				Amount= Amount * 105.94;
				break;
			case "YEN":
				Amount= Amount * 187.72;
				break;
			case "WON":
				Amount= Amount * 1696.63;
				break;
			case "Riyal":
				Amount= Amount * 4.78;
				break;
			case "Euro":
				Amount= Amount * 1.17;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
		
		//conversion from YEN to different currency		
		case "YEN":
			switch(cash2) {
			case "YEN":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 0.0068;
				break;
			case "GBP":
				Amount= Amount * 0.0053;
				break;
			case "INR":
				Amount= Amount * 0.56;
				break;
			case "WON":
				Amount= Amount * 9.04;
				break;
			case "Riyal":
				Amount= Amount * 0.025;
				break;
			case "Euro":
				Amount= Amount * 0.0062;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
		
		//conversion from WON to different currency		
		case "WON":
			switch(cash2) {
			case "WON":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 0.00075; 
				break;
			case "GBP":
				Amount= Amount * 0.0000059;
				break;
			case "YEN":
				Amount= Amount * 0.11;
				break;
			case "INR":
				Amount= Amount * 0.062;
				break;
			case "Riyal":
				Amount= Amount * 0.0028;
				break;
			case "Euro":
				Amount= Amount * 0.00069;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;	
			}
			break;
		
		//conversion from Riyal to different currency			
		case "Riyal":
			switch(cash2) {
			case "Riyal":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 0.27;
				break;
			case "GBP":
				Amount= Amount * 0.21;
				break;
			case "YEN":
				Amount= Amount * 39.27;
				break;
			case "WON":
				Amount= Amount * 354.68;
				break;
			case "INR":
				Amount= Amount * 22.17;
				break;
			case "Euro":
				Amount= Amount * 0.24;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
			
		//conversion from Euro to different currency
		case "Euro":
			switch(cash2) {
			case "Euro":
				Amount= Amount * 1;
				break;
			case "USD":
				Amount= Amount * 1.09;
				break;
			case "GBP":
				Amount= Amount * 0.86;
				break;
			case "YEN":
				Amount= Amount * 160.61;
				break;
			case "WON":
				Amount= Amount * 1449.65;
				break;
			case "Riyal":
				Amount= Amount * 4.09;
				break;
			case "INR":
				Amount= Amount * 90.65;
				break;
			default:
			    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
			    break;
			}
			break;
			
		default:
		    JOptionPane.showMessageDialog(null, "Invalid Input: " + cash1 + " to " + cash2);
		    break;
		}
		return Amount;
	}

}
