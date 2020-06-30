package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Contollers.CoursesController;
import java.awt.Font;

public class StudentsInCourseView extends  JFrame  {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final JTable table;
	int courseID=0;
	public CoursesController controller=new CoursesController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsInCourseView frame = new StudentsInCourseView();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public StudentsInCourseView(CoursesController Controller) throws HeadlessException {
		super();
		this.controller = Controller;
		this.table=new JTable();
	}


	  static StudentsInCourseView m_StudentsInCourseView;
	 	
		public static StudentsInCourseView getStudentsInCourseView() {
			if (m_StudentsInCourseView == null)
				m_StudentsInCourseView = new StudentsInCourseView();
			return m_StudentsInCourseView;
		}
		
  public void LoadData(int courseID)
  {
	  TableModel tm=this.controller.GetStudentsInCourse(courseID).getModel();
      this.table.setModel(tm);
      this.setTitle("סטודנטים בקורס מספר"+" "+String.valueOf(courseID));
      this.courseID=courseID;
  }
  
	public StudentsInCourseView() {
		
		setResizable(true);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	    getContentPane().setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
        setPreferredSize(new Dimension(475, 250));
        this.setSize(1600, 700);
        
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

       
        TableModel tm=this.controller.GetStudentsInCourse(1).getModel();
       
        table = new JTable(tm);
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 20));
        table.setRowHeight(30);

        JButton print = new JButton("הדפס");

        // Enables row selection mode and disable column selection
        // mode.
        
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

  	        
        table.setFillsViewportHeight(true);
        
        JScrollPane pane = new JScrollPane(table);
        pane.setFont(new Font("Arial", Font.PLAIN, 25));
        pane.setBounds(73, 5, 452, 402);
          
       
        JPanel command = new JPanel();
        command.add(print);
                              
                   print.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) {
                          MessageFormat header = new  MessageFormat("רשימת סטודנטים בקורס מספר"+" "+String.valueOf(courseID));
                          MessageFormat footer = new  MessageFormat("kernelios");
                          
                          try {
				table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                       }
                   });
        getContentPane().add(command);
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(command, BorderLayout.SOUTH);	
	}

	

}
