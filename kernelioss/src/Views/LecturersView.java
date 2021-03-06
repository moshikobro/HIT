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

import Contollers.CoursesController;
import Contollers.LecturersController;

public class LecturersView extends JFrame {

	
	public LecturersController controller=new LecturersController();
	 final JTable table;
	 AddOrEditLecturerView ad = AddOrEditLecturerView.getAddOrEditLecturerView();
	/**
	 * Launch the application.
	 */
	 
	 
	 static LecturersView m_LecturersView;
	 	
		public static LecturersView getLecturersView() {
			if (m_LecturersView == null)
				m_LecturersView = new LecturersView();
			return m_LecturersView;
		}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturersView frame = new LecturersView();
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
	public LecturersView() {
		setTitle("ניהול מרצים");	
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
            		
           	if (controller.CanBeDeleted(table.getModel().getValueAt( table.getSelectedRow(), 0).toString()) ==true)
             	{
               	 JOptionPane.showMessageDialog(null,"אינך יכול להסיר מרצה זה מכיוון שהוא שובץ לקורס,שים לב כי באפשרותך לשנות את הסטטוס ללא פעיל. ","הודעת מערכת",1);
               	 return;
               }
            		
           	int result= JOptionPane.showConfirmDialog(null,"האם אתה בטוח שברצונך להסיר את המרצה?","הודעת מערכת", JOptionPane.YES_NO_CANCEL_OPTION);
           	 if(result == 0)//yes
             { 
           		
           		int column = 0;
           		int row = table.getSelectedRow();
           		String LecturerID = table.getModel().getValueAt(row, column).toString();
         		
  
           		boolean res=controller.DeleteLecturer(LecturerID);         		
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
           		 JOptionPane.showMessageDialog(null,"התרחשה תקלה במחיקת המרצה!","הודעת מערכת",1);
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
	           		
            		
            		 String lecturerID;
            		 String lecturerFirstName;
            		 String lecturerLastName;
            		 String address;
            		 Date birthDay;
            		 int specializationID_1;
            		 int specializationID_2;
            		 int specializationID_3;
            		 String Phone;
            		 int status=0;
            		
            		            	
            		 lecturerID=table.getModel().getValueAt(row, 0).toString();
            		 lecturerFirstName=table.getModel().getValueAt(row, 1).toString();		             		 
            		 lecturerLastName=table.getModel().getValueAt(row,2).toString();	
            		 address=table.getModel().getValueAt(row,3).toString();
            		 birthDay=convertFromSQLDateToJAVADate(java.sql.Date.valueOf(table.getModel().getValueAt(row, 4).toString()));
            		 Phone=table.getModel().getValueAt(row,8).toString();
            		 status=Integer.parseInt(table.getModel().getValueAt(row,10).toString());
                      specializationID_1=Integer.parseInt(table.getModel().getValueAt(row, 11).toString());
	            	  specializationID_2=Integer.parseInt(table.getModel().getValueAt(row, 12).toString());
	            	  specializationID_3=Integer.parseInt(table.getModel().getValueAt(row,13).toString());
	            	
	            	 
	            	 
	            	  LecturersController lc=new LecturersController( lecturerFirstName, lecturerLastName, lecturerID, address, Phone, birthDay,
	            						 specializationID_1, specializationID_2, specializationID_3,status);
	            	           		              
	            	  ad.LoadLecturerForEdit(lc,table);
	            	  ad.setVisible(true);
            	}
            	else
            	{
            		 JOptionPane.showMessageDialog(null,"אנא בחר מרצה לעריכה","הודעת מערכת",1);
            	}
           	}
            }
        );

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	
            	ad.AddNewLecturer(table);
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
		  //--------------invisible 3 last columns--------------------------//
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
		       
		   
		       //--------------invisible 3 last columns--------------------------//
	  }
	 

}
