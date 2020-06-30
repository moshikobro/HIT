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
	/**
	 * Launch the application.
	 */
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
           	int result= JOptionPane.showConfirmDialog(null,"האם אתה בטוח שברצונך להסיר את המרצה?","הודעת מערכת", JOptionPane.YES_NO_CANCEL_OPTION);
           	 if(result == 0)//yes
             {
           		int column = 0;
           		int row = table.getSelectedRow();
           		String value = table.getModel().getValueAt(row, column).toString();
           		int courseID=Integer.parseInt(value);
           		
           		boolean res=true;
           		//boolean res=controller.DeleteCourse(courseID);
           		
           		if(res==true)
           			if(row+1>= table.getModel().getRowCount())
           			{
           				table.setModel(controller.GetData().getModel());
           				      		       
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

}
