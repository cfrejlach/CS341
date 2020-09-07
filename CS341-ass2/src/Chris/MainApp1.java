package Chris;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

/**
 * 
 * @author Chris
 * 
 * @version 1.0
 */

public class MainApp1{

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp1 window = new MainApp1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame, and grabbing the scrabble tiles and sending them to 
	 * the scrabble class to get scrambled 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter 4 Scrabble tiles ");
		lblNewLabel.setFont(new Font("Terminator Two", Font.PLAIN, 17));
		lblNewLabel.setBounds(88, 11, 283, 22);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 43, 257, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Every combination of provieded letters ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = textField.getText();
				if(x.length() > 6) {
					textArea.setText("Input invalid enter 6 or less tiles");
				}else {
					Scrabble.main(x);
					textArea.setText(Scrabble.getResult());
				}
			}
		});
		btnNewButton.setFont(new Font("Terminator Two", Font.PLAIN, 13));
		btnNewButton.setBounds(46, 93, 352, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 127, 414, 123);
		frame.getContentPane().add(textArea);
			
	}
}
