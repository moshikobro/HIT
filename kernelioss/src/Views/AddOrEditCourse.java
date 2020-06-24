package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.util.calendar.BaseCalendar.Date;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.text.DateFormat;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import com.mindfusion.common.DateTime;

public class AddOrEditCourse extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=102,149
	 */
	private final DateTime dateTime = new DateTime(0L);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrEditCourse frame = new AddOrEditCourse();
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
	public AddOrEditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E7\u05D5\u05E8\u05E1:");
		lblNewLabel.setBounds(521, 36, 69, 14);
		contentPane.add(lblNewLabel);
		
		TextField txtCourseId = new TextField();
		txtCourseId.setEditable(false);
		txtCourseId.setEnabled(false);
		txtCourseId.setBounds(443, 28, 59, 22);
		contentPane.add(txtCourseId);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E1\u05D5\u05D2 \u05E7\u05D5\u05E8\u05E1:");
		lblNewLabel_1.setBounds(533, 75, 69, 22);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cmbCourseType = new JComboBox();
		cmbCourseType.setBounds(395, 75, 110, 22);
		contentPane.add(cmbCourseType);
		
		JLabel lblNewLabel_2 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4:");
		lblNewLabel_2.setBounds(509, 124, 90, 22);
		contentPane.add(lblNewLabel_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		formattedTextField.setBounds(317, 125, 118, 20);
		contentPane.add(formattedTextField);
		
		JComboBox datePicker;
		Date date = (Date) datePicker.getModel().getValue()
	}
}
