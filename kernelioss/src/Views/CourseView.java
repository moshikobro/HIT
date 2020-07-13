

package Views;

import Contollers.CoursesController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.JPanel;
import Views.AddOrEditCourseView;
import Models.Course;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public  class CourseView extends  JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	public static JTable rs=null;
	public CoursesController controller=new CoursesController();
	 final JTable table;
	  AddOrEditCourseView ad = AddOrEditCourseView.getAddOrEditCourseView();

      JButton remove = new JButton("הסר");
      JButton clear = new JButton("נקה בחירה");
      JButton add = new JButton("הוסף");
      JButton edit = new JButton("ערוך");
      JButton readOnly = new JButton("צפה בפרטים");
      JButton students = new JButton("סטודנטים בקורס");

			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CourseView frame = new CourseView();
							frame.setSize(1600, 700);
							
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		
		public CourseView(CoursesController Controller) throws HeadlessException {
			super();
			this.controller = Controller;
			this.table=new JTable();
		}
		
	
	  static CourseView m_CourseView;
	 	
		public static CourseView getCourseView() {
			if (m_CourseView == null)
				m_CourseView = new CourseView();
			return m_CourseView;
		}
	

	public CourseView() {
	
		   		
			setTitle("ניהול קורסים");	
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
			
	        TableModel  tm=this.controller.GetData().getModel();
	        table = new JTable(tm);
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		if(table.getSelectedRow() != -1)
	            	{
	        		  int row = table.getSelectedRow();
		           	  Date endDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 3).toString()));
		           		if (endDate.before(new Date())==true)
		           		{
		           			edit.setEnabled(false);
		           		}
		           		else
		           		{
		           			edit.setEnabled(true);
		           		}
		           		
	            	}
	        	}
	        });
 	        
	        RemoveColumns(table);
	    
	        
	        table.setFillsViewportHeight(true);
	        JScrollPane pane = new JScrollPane(table); 

	      
	        ListSelectionModel selectionModel = table.getSelectionModel();
	        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        
	        
	        table.setRowSelectionAllowed(true);
	        table.setColumnSelectionAllowed(false);

	        // Select rows based on the input.
	        remove.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	if(table.getSelectedRow() != -1)
	            	{
	            		int column = 0;
		           		int row = table.getSelectedRow();
		           		String value = table.getModel().getValueAt(row, column).toString();
		           		int courseID=Integer.parseInt(value);
		           		
	            		if(controller.IsCourseHaveStudents(courseID)==true)
	            		{
	            			 JOptionPane.showMessageDialog(null,"לא ניתן למחוק את הקורס מכיוון שרשומים אליו סטודנטים!","הודעת מערכת",1);
	            			 return;
	            		}
	            		
	            	int result= JOptionPane.showConfirmDialog(null,"האם אתה בטוח שברצונך להסיר את הקורס?","הודעת מערכת", JOptionPane.YES_NO_CANCEL_OPTION);
	                if(result == 0)//yes
	                {
	           		 		
	           		boolean res=controller.DeleteCourse(courseID);
	           		
	           		if(res==true)
	           			if(row+1>= table.getModel().getRowCount())
	           			{
	           				table.setModel(controller.GetData().getModel());
	           				
	           			     RemoveColumns(table);        		       
	           			}
	           		
	           			else
	           			{
	           				((DefaultTableModel) tm).removeRow(table.getSelectedRow());
	           			}
	           		else
	           		{
	           		 JOptionPane.showMessageDialog(null,"התרחשה תקלה במחיקת השורה!","הודעת מערכת",1);
	           		}

	             }
	         else if(result == 1)//no
	             {
	        	 JOptionPane.getRootFrame().dispose();
	             }
	         else if (result == 2)//cancel
	             {
	        	 JOptionPane.getRootFrame().dispose();
	             }
	         else if (result == -1)//x
	             {
	        	 JOptionPane.getRootFrame().dispose();
	             }
	            	}
	            	else
	            	{
	            		 JOptionPane.showMessageDialog(null,"אנא בחר קורס למחיקה","הודעת מערכת",1);
	            	}
	            }
	        });

	        // Clears row selection
	        clear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                table.removeRowSelectionInterval(0, table.getRowCount() - 1);
	            }
	        });
	        
	        students.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if(table.getSelectedRow() != -1)
	            	{
	            		StudentsInCourseView sc =new StudentsInCourseView();
	            		sc.LoadData(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow() , 0).toString()));
	            		sc.setVisible(true);
	            	}
	            	else
	            	{
	            		 JOptionPane.showMessageDialog(null,"אנא בחר קורס ","הודעת מערכת",1);
	            	}
	            }
	        });
	        
	        
	        edit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if(table.getSelectedRow() != -1)
	            	{
	            		int row = table.getSelectedRow();	
	            		ad.setLoanMode(true);
		            	ad.LoadCourseForEdit(GetSelectedRowData(row),table);
		            	ad.setVisible(true);
	          
	            	}
	            	else
	            	{
	            		 JOptionPane.showMessageDialog(null,"אנא בחר קורס לעריכה","הודעת מערכת",1);
	            	}
	           	}
	            }
	        );

	        // Add one more row after the last selected row.
	        add.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	
	            	ad.setLoanMode(true);
	            	ad.AddNewCourse(table);
	            	ad.setVisible(true);       
	            }
	        });
	        
	    
	        readOnly.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if(table.getSelectedRow() != -1)
	            	{
	            		int row = table.getSelectedRow();
	            		ad.setLoanMode(true);
		            	ad.LoadCourseForReadOnly(GetSelectedRowData(row));            	
		            	ad.setVisible(true);
	          
	            	}
	            	else
	            	{
	            		 JOptionPane.showMessageDialog(null,"אנא בחר קורס לעריכה","הודעת מערכת",1);
	            	}
	           	}
	            }
	        );

	        JPanel command = new JPanel(new FlowLayout());
	        command.add(remove);
	        command.add(clear);
	        command.add(add);
	        command.add(edit);
	        command.add(students);
	        command.add(readOnly);
	        
	        getContentPane().add(pane, BorderLayout.CENTER);
	        getContentPane().add(command, BorderLayout.SOUTH);		      
	}

	
	public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
	
	

  private void RemoveColumns (JTable table)
  {
	  //--------------invisible 5 last columns--------------------------//
	    int numOfCol=table.getColumnModel().getColumnCount();
	       table.getColumnModel().getColumn(numOfCol-1).setWidth(0);
	       table.getColumnModel().getColumn(numOfCol-1).setMinWidth(0);
	       table.getColumnModel().getColumn(numOfCol-1).setMaxWidth(0);
	       
	       table.getColumnModel().getColumn(numOfCol-2).setWidth(0);
	       table.getColumnModel().getColumn(numOfCol-2).setMinWidth(0);
	       table.getColumnModel().getColumn(numOfCol-2).setMaxWidth(0);
	       
	       table.getColumnModel().getColumn(numOfCol-3).setWidth(0);
	       table.getColumnModel().getColumn(numOfCol-3).setMinWidth(0);
	       table.getColumnModel().getColumn(numOfCol-3).setMaxWidth(0);
	       
	       table.getColumnModel().getColumn(numOfCol-4).setWidth(0);
	       table.getColumnModel().getColumn(numOfCol-4).setMinWidth(0);
	       table.getColumnModel().getColumn(numOfCol-4).setMaxWidth(0);
	       
	       table.getColumnModel().getColumn(numOfCol-5).setWidth(0);
	       table.getColumnModel().getColumn(numOfCol-5).setMinWidth(0);
	       table.getColumnModel().getColumn(numOfCol-5).setMaxWidth(0);
	       
	       //--------------invisible 5 last columns--------------------------//
  }

  private CoursesController GetSelectedRowData(int row)
  {


		int  corseID=0;
		 int  corseTypeID=0;
		 Date startDate;
		 Date endDate;
  	 int  dayOfWeekID=0;
  	
		  corseID=Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		  corseTypeID=Integer.parseInt(table.getModel().getValueAt(row, 15).toString());		             		 
		 
		  startDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 2).toString()));
		  endDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 3).toString()));
  	  dayOfWeekID=Integer.parseInt(table.getModel().getValueAt(row, 19).toString());
  	
  	 Date networkingStartDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 8).toString()));
  	 Date systemStartDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 10).toString()));
  	 Date syberStartDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 12).toString()));
  	 Date networkingEndDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 9).toString()));
  	 Date systemEndDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 11).toString()));
  	 Date  syberEndDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 13).toString()));
  	 Date  testDate=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 14).toString()));;
  		
  	 int  networkingLecturerID=Integer.parseInt(table.getModel().getValueAt(row, 16).toString());
  	 int  systemLecturerID=Integer.parseInt(table.getModel().getValueAt(row, 17).toString());
  	 int  syberLecturerID=Integer.parseInt(table.getModel().getValueAt(row,18).toString());
  	 
  	 CoursesController cs=new CoursesController(corseID,corseTypeID,startDate,endDate,dayOfWeekID,networkingLecturerID,systemLecturerID,syberLecturerID,networkingStartDate
  			 ,systemStartDate,syberStartDate,networkingEndDate,systemEndDate,syberEndDate,testDate);
  	 return cs;
  }
	
	

}
