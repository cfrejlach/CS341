package chrisV2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Chris
 * 
 * @version 1.0
 *
 */
public class MainApp2 {
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp2 window = new MainApp2();
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
	public MainApp2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password Checker");
		lblNewLabel.setFont(new Font("STHupo", Font.PLAIN, 19));
		lblNewLabel.setBounds(115, 11, 192, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(162, 53, 186, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter 8 or more characters");
		lblNewLabel_1.setFont(new Font("STHupo", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 56, 149, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.YELLOW);
		textArea.setBounds(71, 144, 289, 83);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = textField.getText();
				if(x.length() >= 8) {
					Analyze.analyze(x);
					textArea.setText(Analyze.getResult());
				}else textField.setText("Not enough characters, Enter 8 or more");
			}
		});
		btnNewButton.setBounds(352, 52, 72, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
