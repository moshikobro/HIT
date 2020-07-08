package Views;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import javax.swing.JButton;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainView extends JFrame  implements Runnable{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
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
	public MainView() {
		setResizable(false);
		setTitle("\u05D1\u05E8\u05D5\u05DB\u05D9\u05DD \u05D4\u05D1\u05D0\u05D9\u05DD \u05DC\u05E7\u05E8\u05E0\u05DC\u05D9\u05D5\u05E1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 548);
		this.setSize(1600, 700);
		
		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		   
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 1600, 33);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JButton btnStudents = new JButton("\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8\u05D9\u05DD");
		btnStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	StudentsView sv=new StudentsView();
            	sv.setVisible(true);
            }
        });
		panel.add(btnStudents);
		
		JSeparator separator_1 = new JSeparator();
		panel.add(separator_1);
		
		JButton btnCourses = new JButton("\u05E7\u05D5\u05E8\u05E1\u05D9\u05DD");
		btnCourses.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              CourseView cs=new CourseView();
	              cs.setVisible(true);
	            }
	        });
	        
		panel.add(btnCourses);
		
		JSeparator separator_2 = new JSeparator();
		panel.add(separator_2);
		
		JButton btnLecturers = new JButton("\u05DE\u05E8\u05E6\u05D9\u05DD");
		btnLecturers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	LecturersView lv=new LecturersView();
              lv.setVisible(true);
            }
        });
		panel.add(btnLecturers);
		
		
		ImageIcon icon = new ImageIcon("img/Main.png");
		Image image = icon.getImage();
		JPanel panel_1 = new JPanel(){
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, getWidth(), getHeight(), getParent());
		    }
		};
		
		panel_1.setBounds(0, 33, 1600, 700);
		contentPane.add(panel_1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
