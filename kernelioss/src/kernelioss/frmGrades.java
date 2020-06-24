package kernelioss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class frmGrades {

	private JFrame frmGrades;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGrades window = new frmGrades();
					window.frmGrades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmGrades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrades = new JFrame();
		frmGrades.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frmGrades.setTitle("\u05E6\u05D9\u05D5\u05E0\u05D9\u05DD");
		frmGrades.setBounds(100, 100, 637, 383);
		frmGrades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrades.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u05DE\u05D9\u05D9\u05E9\u05DD \u05D4\u05D2\u05E0\u05D4 \u05D1\u05E1\u05D9\u05D9\u05D1\u05E8", "Python"}));
		comboBox.setBounds(375, 39, 166, 22);
		frmGrades.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u05D1\u05D7\u05E8 \u05E7\u05D5\u05E8\u05E1");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(551, 39, 60, 18);
		frmGrades.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(0, 87, 621, 257);
		frmGrades.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u05E6\u05D9\u05D5\u05DF", "\u05EA.\u05D6", "\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4", "\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("   \u05E2\u05E8\u05D9\u05DB\u05D4   ");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBounds(264, 39, 89, 23);
		frmGrades.getContentPane().add(btnNewButton);
	}
}
