/////////////////////////////////////////////////////////////////////
/*
 * Author: Leonardo Garcia Calderon
 * GitHub: leogacia1
 */
/////////////////////////////////////////////////////////////////////

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

// calculator application that can add, subtract, multiply, and divide
public class CalculatorApp implements ActionListener {
	
	private JFrame frame;
	private JPanel gui;
	private JTextArea screen;
	private JTextArea screen2;
	private JPanel panelButtons;
	private JButton addButton;
	private JButton subtractButton;
	private JButton divideButton;
	private JButton multiplyButton;
		
	// constructor that sets up the panel and frame of the app
	public CalculatorApp() {
		
		// creating a panel to set as content pane
		gui = new JPanel(new BorderLayout(5, 5));
		gui.setBorder(new EmptyBorder(4, 4, 4, 4));    // adds padding
		
		// creating text area
		screen = new JTextArea(1, 5);
		screen2 = new JTextArea(1, 5);
		screen.setText("0");
		gui.add(screen, BorderLayout.NORTH);
		gui.add(screen2, BorderLayout.CENTER);
		
		// creating frame and setting content pane as gui
		frame = new JFrame("Calculator");
		frame.setContentPane(gui);
		
		// creating panel for the buttons
		panelButtons = new JPanel(new GridLayout(2, 2, 4, 4));
		
		// add button
		addButton = new JButton("+");
		addButton.setActionCommand("+");
		addButton.addActionListener(this);
		// subtract button
		subtractButton = new JButton("-");
		subtractButton.setActionCommand("-");
		subtractButton.addActionListener(this);
		// divide button
		divideButton = new JButton("/");
		divideButton.setActionCommand("/");
		divideButton.addActionListener(this);
		// multiply button
		multiplyButton = new JButton("*");
		multiplyButton.setActionCommand("*");
		multiplyButton.addActionListener(this);
		// add buttons to panelButtons
		panelButtons.add(addButton);
		panelButtons.add(subtractButton);
		panelButtons.add(divideButton);
		panelButtons.add(multiplyButton);
		
		// adding panel to frame
		frame.add(panelButtons, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	// adds the numbers and sets the first text area as the sum
	private void add(double x, double y) {
		screen.setText(Double.toString(x + y));
		screen2.setText("");
	}
	
	// subtracts the numbers and sets the first text area as the difference
	private void subtract(double x, double y) {
		screen.setText(Double.toString(x - y));
		screen2.setText("");
	}
	
	// multiplies the numbers and sets the first text area as the product
	private void multiply(double x, double y) {
		screen.setText(Double.toString(x * y));
		screen2.setText("");
	}
	
	// divides the numbers and sets the first text area as the quotient
	private void divide(double x, double y) {
		screen.setText(Double.toString(x / y));
		screen2.setText("");
	}
	
	public static void main(String[] args) {
		// runs the application
		new CalculatorApp();
	}

	// this method is called once the user presses a button
	@Override
	public void actionPerformed(ActionEvent e) {
		double x = Double.parseDouble(screen.getText());
		double y = Double.parseDouble(screen2.getText());
		
		String command = e.getActionCommand();
		
		if (command.equals("+")) { add(x, y); }
		if (command.equals("-")) { subtract(x, y); }
		if (command.equals("*")) { multiply(x, y); }
		if (command.equals("/")) { divide(x, y); }
		
	}

}