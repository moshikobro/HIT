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
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.SystemColor;

public class AddOrEditLecturerView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrEditLecturerView frame = new AddOrEditLecturerView();
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
	public AddOrEditLecturerView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 462);
		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA :");
		lblNewLabel.setBounds(574, 65, 70, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtLecturerID = new JTextArea();
		txtLecturerID.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyTyped(KeyEvent e) {
					 if (txtLecturerID.getText().length() >= 9 ) // limit textfield to 9 characters
				            e.consume(); 
			}
		});
		txtLecturerID.setBounds(419, 66, 140, 15);
		contentPane.add(txtLecturerID);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
		lblNewLabel_1.setBounds(592, 107, 52, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtFirstName = new JTextArea();
		txtFirstName.setBounds(419, 108, 140, 15);
		contentPane.add(txtFirstName);
		
		JLabel lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
		lblNewLabel_2.setBounds(574, 151, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea txtLastName = new JTextArea();
		txtLastName.setBounds(419, 152, 140, 15);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel_3 = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		lblNewLabel_3.setBounds(598, 196, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtAdderss = new JTextArea();
		txtAdderss.setBounds(419, 197, 140, 15);
		contentPane.add(txtAdderss);
		
		JLabel lblNewLabel_4 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");
		lblNewLabel_4.setBounds(574, 240, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JDateChooser dtpBirthDay = new JDateChooser();
		dtpBirthDay.setBounds(419, 234, 140, 20);
		dtpBirthDay.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpBirthDay);
		
		JLabel lblNewLabel_5 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 1 :");
		lblNewLabel_5.setBounds(583, 276, 61, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox cmbSpecializationID_1 = new JComboBox();
		cmbSpecializationID_1.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_1.setBounds(419, 272, 140, 22);
		contentPane.add(cmbSpecializationID_1);
		
		JLabel lblNewLabel_6 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 2 :");
		lblNewLabel_6.setBounds(583, 312, 61, 14);
		contentPane.add(lblNewLabel_6);
		
		JComboBox cmbSpecializationID_2 = new JComboBox();
		cmbSpecializationID_2.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_2.setBounds(419, 308, 140, 22);
		contentPane.add(cmbSpecializationID_2);
		
		JLabel lblNewLabel_7 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 3 :");
		lblNewLabel_7.setBounds(583, 349, 61, 14);
		contentPane.add(lblNewLabel_7);
		
		JComboBox cmbSpecializationID_3 = new JComboBox();
		cmbSpecializationID_3.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_3.setBounds(419, 345, 140, 22);
		contentPane.add(cmbSpecializationID_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 376, 140, 46);
		contentPane.add(panel);
		
		JButton btnCancel = new JButton("\u05D1\u05D8\u05DC");
		panel.add(btnCancel);
		
		JButton btnSave = new JButton("\u05E9\u05DE\u05D5\u05E8");
		panel.add(btnSave);
	}
}
