package Views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

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

import Contollers.CoursesController;
import Contollers.LecturersController;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Toolkit;

public class AddOrEditLecturerView extends JFrame {

	private JPanel contentPane;	private JTextArea txtLecturerID =new JTextArea();	
	private JTextArea txtFirstName =new JTextArea();
	private JTextArea txtLastName =new JTextArea();
	private JTextArea txtAdderss=new JTextArea();	
	private JDateChooser dtpBirthDay =new JDateChooser() ;
	private JComboBox cmbSpecializationID_1 =new JComboBox() ;	
	private JComboBox cmbSpecializationID_2	 =new JComboBox();
	private JComboBox cmbSpecializationID_3  =new JComboBox();	
	private JComboBox cmbStatus = new JComboBox();
	private JTextArea txtPhone =new JTextArea();
	private String frameTitel=null;
	private int i=0;
	private	int currentSpecializationID_1=0;
	private	int currentSpecializationID_2=0;
	private	int currentSpecializationID_3=0;
	private String selectedSpecializationID_1=null;
    private String selectedSpecializationID_2=null;
    private String selectedSpecializationID_3=null;
    private String selectedStatus=null;
    private JTable m_table=new JTable();
    private LecturersController lecturersController=new LecturersController();
    static AddOrEditLecturerView frame = new AddOrEditLecturerView();
    Date currentDate=new Date();
 
 static AddOrEditLecturerView m_AddOrEditLecturerView;
 	
	public static AddOrEditLecturerView getAddOrEditLecturerView() {
		if (m_AddOrEditLecturerView == null)
			m_AddOrEditLecturerView = new AddOrEditLecturerView();
		return m_AddOrEditLecturerView;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	   public void LoadLecturerForEdit(LecturersController l,JTable table)
	   {
		  
	       this.setTitle("עריכת מרצה");
	       frameTitel="עריכת מרצה";
	   
		   this.txtLecturerID.setText(l.GetID());
		   this.txtLecturerID.setEnabled(false);
		   this.txtFirstName.setText(l.GetfirstName());
		   this.txtLastName.setText(l.GetLastName());
		   this.txtAdderss.setText(l.GetAddress());
		   this.txtPhone.setText(l.GetPhoneNumber());
		  		   
		   cmbSpecializationID_1.setSelectedIndex(l.GetSpecializationID_1()-1);
		   currentSpecializationID_1=l.GetSpecializationID_1()-1;
		   cmbSpecializationID_2.setSelectedIndex(l.GetSpecializationID_2()-1);
		   currentSpecializationID_2=l.GetSpecializationID_2()-1;
		   cmbSpecializationID_3.setSelectedIndex(l.GetSpecializationID_3()-1);
		   currentSpecializationID_3=l.GetSpecializationID_3()-1;
		   this.dtpBirthDay.setDate(l.GetbirthDate());
		   cmbStatus.setSelectedIndex(l.GetStatus());
		   this.m_table=table;	
	
	   }
	   
	   public void AddNewLecturer(JTable table)
	   {
	       this.setTitle("הוספת מרצה");
	       frameTitel="הוספת מרצה";
	       
	       this.txtLecturerID.setText("");
		   this.txtLecturerID.setEnabled(true);
		   this.txtFirstName.setText("");
		   this.txtLastName.setText("");
		   this.txtAdderss.setText("");
		   this.txtPhone.setText("");
		  		   
		   cmbSpecializationID_1.setSelectedIndex(-1);
		   currentSpecializationID_1=-1;
		   cmbSpecializationID_2.setSelectedIndex(-1);
		   currentSpecializationID_2=-1;
		   cmbSpecializationID_3.setSelectedIndex(-1);
		   currentSpecializationID_3=-1;
		   cmbStatus.setSelectedIndex(-1);
		   this.dtpBirthDay.setDate(new Date());
		   
		
		   this.m_table=table;	  
	   }
	
	@SuppressWarnings("unchecked")
	public AddOrEditLecturerView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 462);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA :");
		lblNewLabel.setBounds(574, 31, 70, 14);
		contentPane.add(lblNewLabel);
		
		txtLecturerID.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
					 if (txtLecturerID.getText().length() >= 9 ) 
				            e.consume(); 
			}
		});
		
	
		txtLecturerID.setBounds(419, 32, 140, 15);
		contentPane.add(txtLecturerID);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
		lblNewLabel_1.setBounds(592, 72, 52, 14);
		contentPane.add(lblNewLabel_1);
		
		txtFirstName.setBounds(419, 73, 140, 15);
		contentPane.add(txtFirstName);
		
		JLabel lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
		lblNewLabel_2.setBounds(574, 115, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		txtLastName.setBounds(419, 116, 140, 15);
		contentPane.add(txtLastName);
		
		JLabel lblNewLabel_3 = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA :");
		lblNewLabel_3.setBounds(598, 167, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtAdderss.setBounds(419, 168, 140, 15);
		contentPane.add(txtAdderss);
		
		JLabel lblNewLabel_4 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");
		lblNewLabel_4.setBounds(574, 240, 70, 14);
		contentPane.add(lblNewLabel_4);
		
	
		dtpBirthDay.setBounds(419, 234, 140, 20);
		dtpBirthDay.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpBirthDay);
		
		JLabel lblNewLabel_5 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 1 :");
		lblNewLabel_5.setBounds(583, 276, 61, 14);
		contentPane.add(lblNewLabel_5);
		
		 TableModel tmSpecializations=this.lecturersController.GetSpecializations().getModel();
	     final JTable tableSpecializations = new JTable(tmSpecializations);
	     
	     Map<String,String> mapSpecialization= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializations.getRowCount())
		{
			mapSpecialization.put(tableSpecializations.getValueAt(i,0).toString(),tableSpecializations.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecialization = new KeyValueComboboxModel();
		modelSpecialization.putAll(mapSpecialization);
		
		cmbSpecializationID_1 = new JComboBox<Object>(modelSpecialization);
    
		cmbSpecializationID_1.setRenderer(new DefaultListCellRenderer(){  	            
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                  
					Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
        cmbSpecializationID_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbSpecializationID_1.getSelectedItem()!=null){
                	selectedSpecializationID_1= (KeyToString((java.util.Map.Entry<String, String>) cmbSpecializationID_1.getSelectedItem()));
                	if (  ( selectedSpecializationID_2!=null && (Integer.parseInt(selectedSpecializationID_2)==Integer.parseInt(selectedSpecializationID_1)) )|| 
                			(selectedSpecializationID_3!=null &&(Integer.parseInt(selectedSpecializationID_3)==Integer.parseInt(selectedSpecializationID_1)))
                			)
                
                	{
                		 JOptionPane.showMessageDialog(null,"התמחות זו כבר נבחרה","הודעת מערכת",1);
                		 cmbSpecializationID_1.setSelectedIndex(-1);
                		 selectedSpecializationID_1=null;
	                      	return;
                	}
                } else {
                	selectedSpecializationID_1=null;
                }
            }
        });
		
		cmbSpecializationID_1.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_1.setBounds(419, 272, 140, 22);
		contentPane.add(cmbSpecializationID_1);
		
		JLabel lblNewLabel_6 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 2 :");
		lblNewLabel_6.setBounds(583, 312, 61, 14);
		contentPane.add(lblNewLabel_6);
		
		 TableModel tmSpecializations2=this.lecturersController.GetSpecializations().getModel();
	     final JTable tableSpecializations2 = new JTable(tmSpecializations2);
	     
	     Map<String,String> mapSpecialization2= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializations2.getRowCount())
		{
			mapSpecialization2.put(tableSpecializations2.getValueAt(i,0).toString(),tableSpecializations2.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecialization2 = new KeyValueComboboxModel();
		modelSpecialization2.putAll(mapSpecialization2);
		
		cmbSpecializationID_2 = new JComboBox<Object>(modelSpecialization2);
	    
		cmbSpecializationID_2.setRenderer(new DefaultListCellRenderer(){  	            
			@SuppressWarnings("rawtypes")
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                  
					Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
		cmbSpecializationID_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbSpecializationID_2.getSelectedItem()!=null){
                	selectedSpecializationID_2= (KeyToString((java.util.Map.Entry<String, String>) cmbSpecializationID_2.getSelectedItem()));
                	if (     ( selectedSpecializationID_1!=null && (Integer.parseInt(selectedSpecializationID_1)==Integer.parseInt(selectedSpecializationID_2)) )|| 
                			(selectedSpecializationID_3!=null &&(Integer.parseInt(selectedSpecializationID_3)==Integer.parseInt(selectedSpecializationID_2)))
                	)
                	{
                		 JOptionPane.showMessageDialog(null,"התמחות זו כבר נבחרה","הודעת מערכת",1);
                		 cmbSpecializationID_2.setSelectedIndex(-1);
                		 selectedSpecializationID_2=null;
	                      	return;
                	}
                } else {
                	selectedSpecializationID_2=null;
                }
            }
        });
        
		cmbSpecializationID_2.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_2.setBounds(419, 308, 140, 22);
		contentPane.add(cmbSpecializationID_2);
		
		JLabel lblNewLabel_7 = new JLabel("\u05D4\u05EA\u05DE\u05D7\u05D5\u05EA 3 :");
		lblNewLabel_7.setBounds(583, 349, 61, 14);
		contentPane.add(lblNewLabel_7);
		
		 TableModel tmSpecializations3=this.lecturersController.GetSpecializations().getModel();
	     final JTable tableSpecializations3 = new JTable(tmSpecializations3);
	     
	     Map<String,String> mapSpecialization3= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializations3.getRowCount())
		{
			mapSpecialization3.put(tableSpecializations3.getValueAt(i,0).toString(),tableSpecializations3.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecialization3= new KeyValueComboboxModel();
		modelSpecialization3.putAll(mapSpecialization3);
		
      cmbSpecializationID_3 = new JComboBox<Object>(modelSpecialization3);
	     
	  cmbSpecializationID_3.setRenderer(new DefaultListCellRenderer(){  	            
			@SuppressWarnings("rawtypes")
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                  
					Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
		cmbSpecializationID_3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbSpecializationID_3.getSelectedItem()!=null){
                	selectedSpecializationID_3= (KeyToString((java.util.Map.Entry<String, String>) cmbSpecializationID_3.getSelectedItem()));
                	if (     ( selectedSpecializationID_1!=null && (Integer.parseInt(selectedSpecializationID_1)==Integer.parseInt(selectedSpecializationID_3)) )|| 
                			(selectedSpecializationID_2!=null &&(Integer.parseInt(selectedSpecializationID_2)==Integer.parseInt(selectedSpecializationID_3)))
                	)
                	{
                		 JOptionPane.showMessageDialog(null,"התמחות זו כבר נבחרה","הודעת מערכת",1);
                		 cmbSpecializationID_3.setSelectedIndex(-1);
                		 selectedSpecializationID_3=null;
	                      	return;
                	}
                } else {
                	selectedSpecializationID_3=null;
                }
            }
        });
		
		cmbSpecializationID_3.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSpecializationID_3.setBounds(419, 345, 140, 22);
		contentPane.add(cmbSpecializationID_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 376, 140, 46);
		contentPane.add(panel);
		
		JButton btnSave = new JButton("\u05E9\u05DE\u05D5\u05E8");
		btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 boolean res=false;
            	 
            	 
            	    if(lecturersController.IsLecturerExists(txtLecturerID.getText())==true &&frameTitel!="עריכת מרצה")
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
           	    
            	           	 
            	     if((selectedSpecializationID_3==null || cmbSpecializationID_3.getSelectedIndex()==-1)&&(selectedSpecializationID_2==null || cmbSpecializationID_2.getSelectedIndex()==-1)&&(selectedSpecializationID_1==null || cmbSpecializationID_1.getSelectedIndex()==-1))
            	     {
                  		 JOptionPane.showMessageDialog(null,"עליך לבחור התמחות אחת לפחות","הודעת מערכת",1);
                      	return;
            	     }
            	 
            	     
            	     if(txtPhone.getText().length()<10)
            	     {
                  		 JOptionPane.showMessageDialog(null,"מספר טלפון צריך להיות באורך 10 ספרות","הודעת מערכת",1);
                      	return;

            	     }
            	     
            	     if(txtLecturerID.getText().length()<9)
            	     {
                  		 JOptionPane.showMessageDialog(null,"מספר זהות צריך להיות באורך 9 ספרות","הודעת מערכת",1);
                      	return;

            	     }
            	     
            	
            	     if(dtpBirthDay.getDate()==null)
            	     {
                  		 JOptionPane.showMessageDialog(null,"עליך למלא תאריך לידה","הודעת מערכת",1);
                      	return;
            	     }
            	   int currentYear=currentDate.getYear();
            	   int birthYear= dtpBirthDay.getDate().getYear();
            	     if(currentYear-birthYear <18)
            	     {
                  		 JOptionPane.showMessageDialog(null,"מרצה חייב להיות מעל גיל 18","הודעת מערכת",1);
                      	return;
            	     }

                	 
            	     if(selectedStatus==null || cmbStatus.getSelectedIndex()==-1)
            	     {
                  		 JOptionPane.showMessageDialog(null,"עליך לבחור סטטוס","הודעת מערכת",1);
                      	return;
            	     }
            	 
            	     if(selectedSpecializationID_1==null)
            	     {
            	    	 selectedSpecializationID_1="0";
            	     }
            	     if(selectedSpecializationID_2==null)
            	     {
            	    	 selectedSpecializationID_2="0";
            	     }
            	     if(selectedSpecializationID_3==null)
            	     {
            	    	 selectedSpecializationID_3="0";
            	     }
            	  LecturersController lc=new LecturersController( txtFirstName.getText(), txtLastName.getText(), txtLecturerID.getText(), txtAdderss.getText(), txtPhone.getText(), dtpBirthDay.getDate(),
            			  Integer.parseInt(selectedSpecializationID_1), Integer.parseInt(selectedSpecializationID_2),Integer.parseInt(selectedSpecializationID_3),Integer.parseInt(selectedStatus));
     	           		               
            
            	if(frameTitel=="עריכת מרצה")
            	{
                res=lecturersController.SetLecturerData(lc);
            	}
            	else
            	{
            	 res=lecturersController.InsertNewLecturer(lc);
            	}
               
               if(res==true)
               {
            	   JOptionPane.showMessageDialog(null,"השמירה בוצעה בהצלחה!","הודעת מערכת",1);
            	   DefaultTableModel  tm=(DefaultTableModel) lecturersController.GetData().getModel();
            	   m_table.setModel(tm);
            	   int numOfCol=m_table.getColumnModel().getColumnCount();
       	        
            	   m_table.getColumnModel().getColumn(numOfCol-1).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-1).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-1).setMaxWidth(0);
        	       
            	   m_table.getColumnModel().getColumn(numOfCol-2).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-2).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-2).setMaxWidth(0);
        	       
            	   m_table.getColumnModel().getColumn(numOfCol-3).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-3).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-3).setMaxWidth(0);
            	   
            	   m_table.getColumnModel().getColumn(numOfCol-4).setWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-4).setMinWidth(0);
            	   m_table.getColumnModel().getColumn(numOfCol-4).setMaxWidth(0);
        	   
               }
               else
               {
            	   JOptionPane.showMessageDialog(null,"ישנה תקלה בשמירת השינויים,אנא פנה למנהל המערכת.","הודעת מערכת",1);
            	   
               }
               
            }
        });
		panel.add(btnSave);
		
		JLabel lblNewLabel_8 = new JLabel("טלפון:");
		lblNewLabel_8.setBounds(605, 204, 39, 14);
		contentPane.add(lblNewLabel_8);
		
		txtPhone.setBounds(419, 208, 140, 15);
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
			 if (txtPhone.getText().length() >= 10 ) 
		             e.consume(); 
			}
		});
		
		contentPane.add(txtPhone);
		
		JLabel lblNewLabel_9 = new JLabel("סטטוס:");
		lblNewLabel_9.setBounds(598, 386, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		
		
		TableModel tmStatus=this.lecturersController.GetStatuses().getModel();
	     final JTable tableStatus= new JTable(tmStatus);
		
	     Map<String,String> mapStatus= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableStatus.getRowCount())
		{
			mapStatus.put(tableStatus.getValueAt(i,0).toString(),tableStatus.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelStatus = new KeyValueComboboxModel();
		modelStatus.putAll(mapStatus);
		
		cmbStatus = new JComboBox<Object>(modelStatus);
    
		cmbStatus.setRenderer(new DefaultListCellRenderer(){  	            
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if(value instanceof Map.Entry){
                  
					Map.Entry<String,String> entry = (java.util.Map.Entry<String, String>) value;
                    String str = entryToString(entry);
                    return super.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
        
		cmbStatus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbStatus.getSelectedItem()!=null){
                	selectedStatus= (KeyToString((java.util.Map.Entry<String, String>) cmbStatus.getSelectedItem()));
                	
                } else {
                	selectedStatus=null;
                }
            }
        });
		
        
		cmbStatus.setBounds(419, 382, 140, 22);
		contentPane.add(cmbStatus);
	}
	
	
	private static String entryToString ( Map.Entry<String, String> entry) {
        String str =entry.getValue();
        return str;
    }
	
	private static String KeyToString ( Map.Entry<String, String> entry) {
        String str =entry.getKey();
        return str;
    }
}
