package kernelioss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmStudents {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStudents window = new frmStudents();
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
	public frmStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD");
		frame.setBounds(100, 100, 607, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(null);
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar.setBounds(0, 0, 591, 27);
		frame.getContentPane().add(toolBar);
		
		JButton btnNewButton = new JButton("   \u05D4\u05D5\u05E1\u05E3   ");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("   \u05D4\u05E1\u05E8   ");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("   \u05E2\u05E8\u05D5\u05DA   ");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u05EA.\u05D6 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(513, 38, 68, 27);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(353, 38, 150, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(0, 76, 591, 246);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u05DE\u05E1\u05E4\u05E8 \u05D8\u05DC\u05E4\u05D5\u05DF", "\u05DB\u05EA\u05D5\u05D1\u05EA", "\u05EA.\u05D6", "\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4", "\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9"
			}
		));
		scrollPane.setViewportView(table);
	}
}
