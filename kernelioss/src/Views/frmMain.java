package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Window.Type;
import java.awt.Toolkit;



public class frmMain {
	
	private JFrame frmWelcomeToKernelios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain window = new frmMain();
					window.frmWelcomeToKernelios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		
		frmWelcomeToKernelios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWelcomeToKernelios.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.

	 */
	private void initialize()  {
		frmWelcomeToKernelios = new JFrame();
		frmWelcomeToKernelios.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		frmWelcomeToKernelios.setType(Type.POPUP);
		frmWelcomeToKernelios.setResizable(false);
		frmWelcomeToKernelios.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmWelcomeToKernelios.setTitle("Welcome to KERNELiOS");
		frmWelcomeToKernelios.setBounds(100, 100, 784, 481);
		//------------------------פתיחה במרכז המסך---------------------------//
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmWelcomeToKernelios.setLocation(dim.width/2-frmWelcomeToKernelios.getWidth()/2, dim.height/2-frmWelcomeToKernelios.getHeight()/2);
		//---------------------------------------------------------------//
		frmWelcomeToKernelios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToKernelios.getContentPane().setLayout(null);
		JToolBar tb = new JToolBar();
		tb.setFont(new Font("Arial", Font.BOLD, 16));
		tb.setRollover(true);
		tb.setBorder(null);
		tb.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tb.setBounds(0, 0, 768,50);
		frmWelcomeToKernelios.getContentPane().add(tb);
		frmWelcomeToKernelios.getContentPane().add(tb,BorderLayout.NORTH);
    
		
		JButton btnNewButton = new JButton("   תשלומי�?   ");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		tb.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("   סטודנטי�?   ");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		tb.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("   ציוני�?   ");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		tb.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("   מרצי�?   ");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		tb.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("   קורסי�?   ");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 16));
		tb.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 83, 778, 358);
		frmWelcomeToKernelios.getContentPane().add(lblNewLabel);
		
		
		BufferedImage img = null;
		try {
			 img = ImageIO.read(new File ("C:\\Users\\Moshiko\\Desktop\\Screenshot_27.png") );
		} catch (IOException e) {
		    e.printStackTrace();
		}
	  

    	Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
		        Image.SCALE_SMOOTH);
    	ImageIcon imageIcon = new ImageIcon(dimg);
		
		lblNewLabel.setIcon(imageIcon);
		
		
	}
}
