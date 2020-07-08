package Views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import Contollers.StudentsController;
import Contollers.CourseObserver;
import Contollers.CoursesController;
import Contollers.LecturersController;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

public class AddOrEditStudentView extends JFrame {

	private JPanel contentPane;
	private JTextArea txtStudentID = new JTextArea();
	private JTextArea txtFirstName = new JTextArea();
	private JTextArea txtLastName = new JTextArea();
	private JTextArea txtAdderss = new JTextArea();
	private JDateChooser dtpBirthDay = new JDateChooser();
	private JTextArea txtPhone = new JTextArea();
	private JComboBox cmbCourses = new JComboBox();
	private JTextArea txtGrade = new JTextArea();
	private String frameTitel=null;
	final JTable tableCoursesForStudents ;
	 private JTable m_table=new JTable();
	 private StudentsController StudentsController=new StudentsController();
	 private CoursesController CoursesController=new CoursesController();
	 private String selectedCourseID=null;
	 int currentCourseID=0;
     int m_courseID=0;
     int i=0;
     boolean loadMode=true;
    
	 static AddOrEditStudentView m_AddOrEditStudentView;
	 	
		public static AddOrEditStudentView getAddOrEditStudentView() {
			if (m_AddOrEditStudentView == null)
				m_AddOrEditStudentView = new AddOrEditStudentView();
			return m_AddOrEditStudentView;
		}
		
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrEditStudentView frame = new AddOrEditStudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	   public void LoadStudentForEdit(StudentsController s,JTable table,int courseID ,Date finalTestDate)
	   {
		  
	       this.setTitle("עריכת סטודנט");
	       frameTitel="עריכת סטודנט";
	   
		   this.txtStudentID.setText(s.GetID());
		   this.txtStudentID.setEnabled(false);
		   this.txtFirstName.setText(s.GetfirstName());
		   this.txtLastName.setText(s.GetLastName());
		   this.txtAdderss.setText(s.GetAddress());
		   this.txtPhone.setText(s.GetPhoneNumber());
		     
		 
			
		  
		   this.m_courseID=courseID; 
		   for(int j=0;j< tableCoursesForStudents.getRowCount();j++)
		   {
			   if(Integer.parseInt(tableCoursesForStudents.getValueAt(j,0).toString())==courseID)
			   {
				  
				   this.cmbCourses.setSelectedIndex(j); 
				   this.cmbCourses.setEnabled(true);
				   this.currentCourseID=j;
				   
			   }
		   }
		  
		   this.dtpBirthDay.setDate(s.GetbirthDate());
		   this.txtGrade.setEnabled(false); 
		   this.txtGrade.setText(String.valueOf(s.GetGrade()));
		   if(finalTestDate.before(new Date()))
		   {
			   this.txtGrade.setEnabled(true); 
		   }
		   if (s.GetGrade()==0)
		   {
			   this.txtGrade.setText(""); 
		   }
		   
		   this.m_table=table;	
		   loadMode=false;
	
	   }
	   
	   public void AddNewStudent(JTable table)
	   {
	       this.setTitle("הוספת סטודנט");
	       frameTitel="הוספת סטודנט";

		   this.txtStudentID.setText("");
		   this.txtStudentID.setEnabled(true);
		   this.txtFirstName.setText("");
		   this.txtLastName.setText("");
		   this.txtAdderss.setText("");
		   this.txtPhone.setText("");
		  		   
		   this.cmbCourses.setSelectedIndex(-1); 
		   this.cmbCourses.setEnabled(true);
		   currentCourseID=-1; 
		   
		 
		   this.dtpBirthDay.setDate(new Date());
		   this.txtGrade.setEnabled(true); 
		   this.txtGrade.setText("");
		  
		   this.m_table=table;	
		   loadMode=false;
	   }
	   
	   public void setLoanMode (boolean b)
	   {
		  this.loadMode=b; 
	   }
	@SuppressWarnings({ "unchecked", "serial" })
	public AddOrEditStudentView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 384);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		lblNewLabel.setBounds(552, 42, 74, 14);
		contentPane.add(lblNewLabel);
		
		
		txtStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				  if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
				 if (txtStudentID.getText().length() >= 9 ) // limit textfield to 9 characters
			            e.consume(); 
			}
		});
		txtStudentID.setBounds(402, 43, 140, 15);
		contentPane.add(txtStudentID);
		
		
		txtFirstName.setBounds(402, 83, 140, 15);
		contentPane.add(txtFirstName);
		
		
		txtLastName.setBounds(402, 121, 140, 15);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
		lblNewLabel_1.setBounds(568, 82, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
		lblLastName.setBounds(552, 120, 74, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAdderss = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		lblAdderss.setBounds(577, 157, 49, 14);
		contentPane.add(lblAdderss);
		
		
		txtAdderss.setBounds(402, 158, 140, 15);
		contentPane.add(txtAdderss);
		
		JLabel txtBirthday = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");
		txtBirthday.setBounds(552, 201, 74, 14);
		contentPane.add(txtBirthday);
		
		
		dtpBirthDay.setBounds(402, 201, 140, 20);
		dtpBirthDay.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpBirthDay);
		
		JLabel lblPhone = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF :");
		lblPhone.setBounds(580, 237, 46, 14);
		contentPane.add(lblPhone);
		
		
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				  if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
				 if (txtPhone.getText().length() >= 10) // limit textfield to 10 characters
			            e.consume(); 
			}
		});
		txtPhone.setBounds(402, 238, 140, 15);
		contentPane.add(txtPhone);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 301, 160, 33);
		contentPane.add(panel);
		
		JButton btnSave = new JButton("\u05E9\u05DE\u05D5\u05E8");
		btnSave.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
            	 boolean res=false;
            	 
            	 
            	    if(StudentsController.IsStudentExists(txtStudentID.getText())==true &&frameTitel!="עריכת סטודנט")
            	    {
           
                	 	JOptionPane.showMessageDialog(null,"תעודת זהות זו כבר קיימת במערכת","הודעת מערכת",1);
                    	return;
            	    }
          	  
            	     if(txtFirstName.getText().toString()==""||txtFirstName.getText().equals("") )
           	        {
                  		 JOptionPane.showMessageDialog(null,"עליך למלא שם פרטי","הודעת מערכת",1);
                     	return;
           	        }
            	     
            	     if(txtLastName.getText()==null ||txtLastName.getText().equals(""))
            	        {
                   		 JOptionPane.showMessageDialog(null,"עליך למלא שם משפחה ","הודעת מערכת",1);
                      	return;
            	        }
           	   
            	     
            	     if(txtPhone.getText().length()<10)
            	     {
                  		 JOptionPane.showMessageDialog(null,"מספר טלפון צריך להיות באורך 10 ספרות","הודעת מערכת",1);
                      	return;

            	     }
            	     
            	     if(txtStudentID.getText().length()<9)
            	     {
                  		 JOptionPane.showMessageDialog(null,"מספר זהות צריך להיות באורך 9 ספרות","הודעת מערכת",1);
                      	return;

            	     }
            	     
            	
            	     if(dtpBirthDay.getDate()==null)
            	     {
                  		 JOptionPane.showMessageDialog(null,"עליך למלא תאריך לידה","הודעת מערכת",1);
                      	return;
            	     }
            	   int currentYear=(new Date()).getYear();
            	   int birthYear= dtpBirthDay.getDate().getYear();
            	     if(currentYear-birthYear <18)
            	     {
                  		 JOptionPane.showMessageDialog(null,"סטודנט חייב להיות מעל גיל 18","הודעת מערכת",1);
                      	return;
            	     }

                	 
            	     if(selectedCourseID==null || cmbCourses.getSelectedIndex()==-1)
            	     {
                  		 JOptionPane.showMessageDialog(null,"עליך לבחור קורס","הודעת מערכת",1);
                      	return;
            	     }
            	     
            	   int grade=0;
            	  if (txtGrade.isEnabled()==true && txtGrade.getText()!=null && txtGrade.getText().equals("")==false)
            	  {
            		   grade =Integer.parseInt(txtGrade.getText());
            		  if (grade<55 || grade > 100)
            		  {
            			  JOptionPane.showMessageDialog(null,"ציון חייב להיות בטווח בין 55 ל-100","הודעת מערכת",1);
                        	return;
            		  }
            		  else
            		  {
            			  
            		  }
            	  }
            	
            	   
            	     
            	     StudentsController s=new StudentsController( txtFirstName.getText(), txtLastName.getText(), txtStudentID.getText(), txtAdderss.getText(), txtPhone.getText(), 
            	    		 dtpBirthDay.getDate(),	grade);
     	           		               
            
            	if(frameTitel=="עריכת סטודנט")
            	{
                res=StudentsController.SetStudentData(s,Integer.parseInt(selectedCourseID));
            	}
            	else
            	{
            	
            	 StudentsController.addObserver(new CourseObserver());
            	 res=StudentsController.InsertNewStudent(s, Integer.parseInt(selectedCourseID));
            	}
               
               if(res==true)
               {
            	   JOptionPane.showMessageDialog(null,"השמירה בוצעה בהצלחה!","הודעת מערכת",1);
            	   DefaultTableModel  tm=(DefaultTableModel) StudentsController.GetData().getModel();
            	   m_table.setModel(tm);
            	   int numOfCol=m_table.getColumnModel().getColumnCount();
       	        
            	   m_table.getColumnModel().getColumn(numOfCol-1).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-1).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-1).setMaxWidth(0);
        	       
            	   m_table.getColumnModel().getColumn(numOfCol-2).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-2).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-2).setMaxWidth(0);
        	   
               }
               else
               {
            	   JOptionPane.showMessageDialog(null,"ישנה תקלה בשמירת השינויים,אנא פנה למנהל המערכת.","הודעת מערכת",1);
            	   
               }
               
            }
        });
		panel.add(btnSave);
		
		JLabel lblNewLabel_2 = new JLabel("\u05D1\u05D7\u05E8 \u05E7\u05D5\u05E8\u05E1:");
		lblNewLabel_2.setBounds(564, 277, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		  TableModel tmCoursesForStudents=this.CoursesController.GetCoursesForStudents().getModel();
		     tableCoursesForStudents = new JTable(tmCoursesForStudents);
		     
		     HashMap<String,String> mapCoursesForStudents= new HashMap<String,String>(){{     
		        }};
		
			i=0;
			while (i<tableCoursesForStudents.getRowCount())
			{
				String a;
				a=tableCoursesForStudents.getValueAt(i,0).toString();
				mapCoursesForStudents.put(tableCoursesForStudents.getValueAt(i,0).toString(),tableCoursesForStudents.getValueAt(i,1).toString());
				i++;
			}
		
		KeyValueComboboxModel modelCoursesForStudents = new KeyValueComboboxModel();
		modelCoursesForStudents.putAll(mapCoursesForStudents);
		
		cmbCourses = new JComboBox<Object>(modelCoursesForStudents);
    
		cmbCourses.setRenderer(new DefaultListCellRenderer(){  	            
		
			@Override
            public Component getListCellRendererComponent( JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                  
					Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
		cmbCourses.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbCourses.getSelectedItem()!=null){
                	selectedCourseID= (KeyToString((java.util.Map.Entry<String, String>) cmbCourses.getSelectedItem()));
                	if ( CoursesController.IsCourseEnded(Integer.parseInt(selectedCourseID))==true&&loadMode==false)             
                	{
                		JOptionPane.showMessageDialog(null,"אינך יכול לבחור בקורס זה מכיוון שהוא הסתיים","הודעת מערכת",1);
                		cmbCourses.setSelectedIndex(currentCourseID);
                   	  selectedCourseID= (KeyToString((java.util.Map.Entry<String, String>) cmbCourses.getSelectedItem()));  
                	}
                	
                }
                else {
                	selectedCourseID=null;
                }
            }
        });
		cmbCourses.setBackground(SystemColor.inactiveCaptionBorder);
		cmbCourses.setBounds(331, 273, 211, 22);
		contentPane.add(cmbCourses);
		
		JLabel lblNewLabel_3 = new JLabel("\u05E6\u05D9\u05D5\u05DF:");
		lblNewLabel_3.setBounds(600, 320, 26, 14);
		contentPane.add(lblNewLabel_3);
		
		
	
		txtGrade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				  if (((caracter < '0') || (caracter > '9'))
	                        && (caracter != '\b')) {
	                    e.consume();
	                }
				 if (txtGrade.getText().length() >= 3 ) // limit textfield to 3 characters
			            e.consume(); 
			}
		});
		txtGrade.setBounds(402, 319, 140, 15);
		contentPane.add(txtGrade);
	}
	
	
	private static String entryToString ( Map.Entry<String, String> entry) {
        String str =entry.getValue() ;
        return str;
    }
	
	private static String KeyToString ( Map.Entry<String, String> entry) {
        String str =entry.getKey();
        return str;
    }
}
