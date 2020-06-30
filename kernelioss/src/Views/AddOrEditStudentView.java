package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddOrEditStudentView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrEditStudentView frame = new AddOrEditStudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddOrEditStudentView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 384);
		

		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		lblNewLabel.setBounds(552, 42, 74, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtStudentID = new JTextArea();
		txtStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 if (txtStudentID.getText().length() >= 9 ) // limit textfield to 9 characters
			            e.consume(); 
			}
		});
		txtStudentID.setBounds(402, 43, 140, 15);
		contentPane.add(txtStudentID);
		
		JTextArea txtFirstName = new JTextArea();
		txtFirstName.setBounds(402, 83, 140, 15);
		contentPane.add(txtFirstName);
		
		JTextArea txtLastName = new JTextArea();
		txtLastName.setBounds(402, 121, 140, 15);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
		lblNewLabel_1.setBounds(568, 82, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
		lblLastName.setBounds(552, 120, 74, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAdderss = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		lblAdderss.setBounds(577, 157, 49, 14);
		contentPane.add(lblAdderss);
		
		JTextArea txtAdderss = new JTextArea();
		txtAdderss.setBounds(402, 158, 140, 15);
		contentPane.add(txtAdderss);
		
		JLabel txtBirthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");
		txtBirthday.setBounds(552, 201, 74, 14);
		contentPane.add(txtBirthday);
		
		JDateChooser dtpBirthDay = new JDateChooser();
		dtpBirthDay.setBounds(402, 201, 140, 20);
		dtpBirthDay.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpBirthDay);
		
		JLabel lblPhone = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF :");
		lblPhone.setBounds(580, 237, 46, 14);
		contentPane.add(lblPhone);
		
		JTextArea txtPhone = new JTextArea();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 if (txtPhone.getText().length() >= 10) // limit textfield to 10 characters
			            e.consume(); 
			}
		});
		txtPhone.setBounds(402, 238, 140, 15);
		contentPane.add(txtPhone);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 301, 160, 33);
		contentPane.add(panel);
		
		JButton btnCancel = new JButton("\u05D1\u05D8\u05DC");
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("\u05E9\u05DE\u05D5\u05E8");
		panel.add(btnSave);
	}
}
