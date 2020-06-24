package Views;

import Contollers.CoursesController;



import java.awt.EventQueue;
import java.awt.HeadlessException;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.microsoft.sqlserver.jdbc.spatialdatatypes.Point;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;




public  class CourseView extends  JFrame implements Runnable{
	

	private static final long serialVersionUID = 1L;
	
	public static JTable rs=null;
	public CoursesController controller=new CoursesController();

	static String s;
	//private JTable table;
	
	public CourseView(CoursesController Controller) throws HeadlessException {
		super();
		this.controller = Controller;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseView frame = new CourseView();
					frame.setSize(1600, 200);
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
	


	
	public CourseView() {
		setTitle("ניהול קורסים");
		
		 JPanel panel = new JTableRowSelectProgrammatically();
	        panel.setOpaque(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setContentPane(panel);
	        this.pack();
	        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	        int height = screenSize.height;
	        int width = screenSize.width;
	        this.setSize(width/2, height/2);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	      
	        
//		setAlwaysOnTop(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 602, 300);
//		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//	   
//		table = new JTable();
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setSize(new Dimension(500, 500));
//		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
//	    table.setFillsViewportHeight(true);
//		 table.setRowSelectionAllowed(true);
//	    table.setColumnSelectionAllowed(false);
//
//		
//	   // rs =controller.GetData();
//		// TableModel tm = rs.getModel();
//		 table.setModel(tm);
//		 
//		    
//	  JScrollPane scrollPane = new JScrollPane(table);
//		    
//	 JButton btnRemove = new JButton("\u05D4\u05E1\u05E8");
//		 btnRemove.addMouseListener(new MouseAdapter() {
//		 	@Override
//		 	public void mouseClicked(MouseEvent e) {
//		 		 JOptionPane.showMessageDialog(null,"האם אתה בטוח שברצונך להסיר את הקורס?","הודעת מערכת",1);
//		 	}
//		 });
//		 
//		 getContentPane().add(btnRemove);
//		 btnRemove.setVisible(true);
//		 
//		 JPanel panel = new JPanel();
//		 getContentPane().add(panel);
//		
		 
		 
		
	//	 this.getContentPane().add( new JScrollPane( table ), BorderLayout.CENTER );
	        
		  // automatically resize the columns whenever the data in the table changes
	   //     table.getModel().addTableModelListener(new TableModelListener() {
	      //      public void tableChanged(TableModelEvent e) {
	      //          ColumnsAutoSizer.sizeColumnsToFit(table);
	     //       }
	    //    });
	        

	        
	       
		      
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
