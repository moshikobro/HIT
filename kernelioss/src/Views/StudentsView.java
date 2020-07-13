package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Contollers.StudentsController;

public class StudentsView extends JFrame {

	
	public StudentsController controller=new StudentsController();
	 final JTable table;
	 AddOrEditStudentView ad = AddOrEditStudentView.getAddOrEditStudentView();

	 
	 static StudentsView m_StudentsView;
	 	
		public static StudentsView getStudentsView() {
			if (m_StudentsView == null)
				m_StudentsView = new StudentsView();
			return m_StudentsView;
		}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsView frame = new StudentsView();
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
	public StudentsView() {
		setTitle("ניהול סטודנטים");	
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
        RemoveColumns(table); 
   
        table.setFillsViewportHeight(true);
        JScrollPane pane = new JScrollPane(table);

 
        JButton remove = new JButton("הסר");
        JButton clear = new JButton("נקה בחירה");
        JButton add = new JButton("הוסף");
        JButton edit = new JButton("ערוך");
       

        // Enables row selection mode and disable column selection
        // mode.
        
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        // Select rows based on the input.
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	if(table.getSelectedRow() != -1)
            	{
            		
            		
           	int result= JOptionPane.showConfirmDialog(null,"האם אתה בטוח שברצונך להסיר את הסטודנט?","הודעת מערכת", JOptionPane.YES_NO_CANCEL_OPTION);
           	 if(result == 0)//yes
             { 
           		
           		int column = 0;
           		int row = table.getSelectedRow();
           		String StudentID = table.getModel().getValueAt(row, column).toString();
         		
  
           		boolean res=controller.DeleteStudent(StudentID);         		
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
           		 JOptionPane.showMessageDialog(null,"התרחשה תקלה במחיקת הסטודנט!","הודעת מערכת",1);
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
            		 JOptionPane.showMessageDialog(null,"אנא בחר מרצה למחיקה","הודעת מערכת",1);
            	}
            }
        });

        // Clears row selection
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.removeRowSelectionInterval(0, table.getRowCount() - 1);
            }
        });
        
       
        
        
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(table.getSelectedRow() != -1)
            	{
            		int row = table.getSelectedRow();
	           		
            		
            		 String studentID;
            		 String studentFirstName;
            		 String studentLastName;
            		 String address;
            		 Date birthDay;
            		 String Phone;
            		 int courseID=0;
            		 int grade=0;
            		 Date finalTest;
            		
            		            	
            		 studentID=table.getModel().getValueAt(row, 0).toString();
            		 studentFirstName=table.getModel().getValueAt(row, 1).toString();		             		 
            		 studentLastName=table.getModel().getValueAt(row,2).toString();	
            		 address=table.getModel().getValueAt(row,3).toString();
            		 birthDay=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 4).toString()));
            		 Phone=table.getModel().getValueAt(row,5).toString();             		
	            	  grade=Integer.parseInt(table.getModel().getValueAt(row,6).toString());
	            	  courseID=Integer.parseInt(table.getModel().getValueAt(row,7).toString());
	            	  finalTest=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 8).toString()));
	            	 
	            	 
	            	  StudentsController s=new StudentsController( studentFirstName, studentLastName, studentID, address, Phone, birthDay,grade);
	            	  ad.setLoanMode(true);		              
	            	  ad.LoadStudentForEdit(s, table, courseID, finalTest);
	            	  ad.setVisible(true);
            	}
            	else
            	{
            		 JOptionPane.showMessageDialog(null,"אנא בחר סטודנט לעריכה","הודעת מערכת",1);
            	}
           	}
            }
        );

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	ad.setLoanMode(true);
            	ad.AddNewStudent(table);
            	ad.setVisible(true);       
            }
        });


        JPanel command = new JPanel(new FlowLayout());
        command.add(remove);
        command.add(clear);
        command.add(add);
        command.add(edit);
        
        add(pane, BorderLayout.CENTER);
        add(command, BorderLayout.SOUTH);	
	}
	
	
	public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
	
	
	 public void RemoveColumns (JTable table)
	  {
		  //--------------invisible 2 last columns--------------------------//
		    int numOfCol=table.getColumnModel().getColumnCount();
		       table.getColumnModel().getColumn(numOfCol-1).setWidth(0);
		       table.getColumnModel().getColumn(numOfCol-1).setMinWidth(0);
		       table.getColumnModel().getColumn(numOfCol-1).setMaxWidth(0);
		       
		       table.getColumnModel().getColumn(numOfCol-2).setWidth(0);
		       table.getColumnModel().getColumn(numOfCol-2).setMinWidth(0);
		       table.getColumnModel().getColumn(numOfCol-2).setMaxWidth(0);
		       		       	 	   
		       //--------------invisible 2 last columns--------------------------//
	  }
	 

}
