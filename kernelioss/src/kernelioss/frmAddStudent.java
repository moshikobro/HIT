package kernelioss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ComponentOrientation;

public class frmAddStudent {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAddStudent window = new frmAddStudent();
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
	public frmAddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 16));
		frame.setBounds(100, 100, 814, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(321, 21, 150, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(648, 107, 63, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(629, 143, 75, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u05EA.\u05D6");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(686, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(665, 214, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(629, 239, 134, 41);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField.setBounds(392, 111, 162, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(392, 179, 162, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(392, 148, 162, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(392, 213, 162, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(392, 251, 162, 20);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("   \u05D4\u05D5\u05E1\u05E3   ");
		btnNewButton.setBounds(354, 311, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
