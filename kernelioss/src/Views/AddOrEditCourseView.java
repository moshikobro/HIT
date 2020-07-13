package Views;
import Models.Course;
import Views.AddOrEditCourseView;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.Toolkit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import Contollers.CoursesController;
import Contollers.LecturersController;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class AddOrEditCourseView extends JFrame {

	private JPanel contentPane;
	TextField txtCourseId = new TextField();
	JComboBox cmbCourseType ;
	JDateChooser dtpStartDate = new JDateChooser();
	JDateChooser dtpEndDate = new JDateChooser();
	JComboBox cmbNetworkingLecturer = new JComboBox();
	JComboBox cmbSystemLecturer = new JComboBox();
	JDateChooser dtpSystemStartDate = new JDateChooser();
	JDateChooser dtpSystemEndDate = new JDateChooser();
	JDateChooser dtpNetworkingStartDate = new JDateChooser();
	JComboBox cmbSyberLecturer = new JComboBox();
	JDateChooser dtpSyberStartDate = new JDateChooser();
	JDateChooser dtpSyberEndDate = new JDateChooser();
	JDateChooser dtpFinalTest = new JDateChooser();
	JDateChooser dtpNetworkingEndDate = new JDateChooser();
	JComboBox cmbDaysOfWeek ;
	 final JTable tableSpecializationInNetwork ;
	 final JTable tableSpecializationInSystem;
	 final JTable tableSpecializationInSyber ;
	private CoursesController coursesController=new CoursesController();
	private CoursesController LoadedcoursesController=new CoursesController();
	private LecturersController lecturersController=new LecturersController();
    private String selectedDayOfWeek=null;
    private String selectedCourseType=null;
    private String selectedNetworkingLecturer=null;
    private String selectedSystemLecturer=null;
    private String selectedSyberLecturer=null;
    int x=0;
    private String frameTitel=null;
    int i=0;
	int currentNetworkingLecturer=0;
	int currentSystemLecturer=0;
	int currentSyberLecturer=0;
	boolean loadMode=true;
	JTable m_table=new JTable();
	static AddOrEditCourseView frame= new AddOrEditCourseView() ;
	JButton btnSave = new JButton("\u05E9\u05DE\u05D5\u05E8");
     static AddOrEditCourseView m_AddOrEditCoursesView;

	public static AddOrEditCourseView getAddOrEditCourseView() {
		if (m_AddOrEditCoursesView == null)
			m_AddOrEditCoursesView = new AddOrEditCourseView();
		return m_AddOrEditCoursesView;
	}
	
   public void LoadCourseForEdit(CoursesController c,JTable table)
   { 
	
       this.setTitle("עריכת קורס");
       frameTitel="עריכת קורס";
       this.LoadedcoursesController=c;
	   this.txtCourseId.setText(String.valueOf(c.GetCourseID()));
	   this.txtCourseId.setEnabled(false);
	   cmbDaysOfWeek.setSelectedIndex(c.GetCourseDayOfWeekID()-1);
	   cmbDaysOfWeek.setEnabled(true);
	   cmbCourseType.setSelectedIndex(c.GetCourseType()-1);
	   cmbCourseType.setEnabled(true);
	   this.dtpStartDate.setDate(c.GetCourseStartDate());
	   dtpStartDate.setEnabled(true);
	   this.dtpEndDate.setDate(c.GetCourseEndDate());
	   dtpEndDate.setEnabled(true);
	   this.dtpSystemStartDate.setDate(c.GetSystemStartDate());
	   dtpSystemStartDate.setEnabled(true);
	   this.dtpSystemEndDate.setDate(c.GetSystemEndDate());
	   dtpSystemEndDate.setEnabled(true);
	   this.dtpNetworkingStartDate.setDate(c.GetNetworkingStartDate());
	   dtpNetworkingStartDate.setEnabled(true);
	   this.dtpNetworkingEndDate.setDate(c.GetNetworkingEndDate());
	   dtpNetworkingEndDate.setEnabled(true);
	   this.dtpSyberStartDate.setDate(c.GetSyberStartDate());
	   dtpSyberStartDate.setEnabled(true);
	   this.dtpSyberEndDate.setDate(c.GetSyberEndDate());
	   dtpSyberEndDate.setEnabled(true);
	   this.dtpFinalTest.setDate(c.GetTestDate());
	   dtpFinalTest.setEnabled(true);
	  
	   for(int i=0;i< tableSpecializationInNetwork.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInNetwork.getValueAt(i,0).toString())==c.GetNetworkingLecturerID())
		   {
			   this.cmbNetworkingLecturer.setSelectedIndex(i); 
			   this.cmbNetworkingLecturer.setEnabled(true);
			 currentNetworkingLecturer =i;
		   }
	   }
	 
	   for(int i=0;i< tableSpecializationInSystem.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInSystem.getValueAt(i,0).toString())==c.GetSystemLecturerID())
		   {
			   this.cmbSystemLecturer.setSelectedIndex(i);
			   this.cmbSystemLecturer.setEnabled(true);
			   currentSystemLecturer=i;
		   }
	   }
	   
	   for(int i=0;i< tableSpecializationInSyber.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInSyber.getValueAt(i,0).toString())==c.GetSyberLecturerID())
		   {
			   this.cmbSyberLecturer.setSelectedIndex(i); 
			   this.cmbSyberLecturer.setEnabled(true);
			   currentSyberLecturer=i;
		   }
	   }
	   this.m_table=table;
	   btnSave.setVisible(true);
	 
	   loadMode=false;
   }
   
   public void setLoanMode (boolean b)
   {
	  this.loadMode=b; 
   }
   public void AddNewCourse(JTable table)
   {
       this.setTitle("הוספת קורס");
       frameTitel="הוספת קורס";
	   this.txtCourseId.setText(String.valueOf(coursesController.GetNextCourseNumber()));
	   this.txtCourseId.setEnabled(false);
	   
	   cmbDaysOfWeek.setSelectedIndex(-1);
	   this.cmbDaysOfWeek.setEnabled(true);
	   
	   cmbCourseType.setSelectedIndex(-1);
	   this.cmbCourseType.setEnabled(true);
	   
	   this.dtpStartDate.setDate(new Date());
	   this.dtpStartDate.setEnabled(true);
	   
	   this.dtpEndDate.setDate(new Date());
	   this.dtpEndDate.setEnabled(true);
	   
	   this.dtpSystemStartDate.setDate(new Date());
	   this.dtpSystemStartDate.setEnabled(true);
	   
	   this.dtpSystemEndDate.setDate(new Date());
	   this.dtpSystemEndDate.setEnabled(true);
	   
	   this.dtpNetworkingStartDate.setDate(new Date());
	   this.dtpNetworkingStartDate.setEnabled(true);
	   
	   this.dtpNetworkingEndDate.setDate(new Date());
	   this.dtpNetworkingEndDate.setEnabled(true);
	   
	   this.dtpSyberStartDate.setDate(new Date());
	   this.dtpSyberStartDate.setEnabled(true);
	   
	   this.dtpSyberEndDate.setDate(new Date());
	   this.dtpSyberEndDate.setEnabled(true);
	   
	   this.dtpFinalTest.setDate(new Date()); 
	   this.dtpFinalTest.setEnabled(true);
	   
	   this.cmbNetworkingLecturer.setSelectedIndex(-1); 
	   this.cmbNetworkingLecturer.setEnabled(true);
	  currentNetworkingLecturer =-1;
	  
	  this.cmbSystemLecturer.setSelectedIndex(-1);
	  this.cmbSystemLecturer.setEnabled(true);
	  currentSystemLecturer=-1;	
	  
	  this.cmbSyberLecturer.setSelectedIndex(-1); 
	  this.cmbSyberLecturer.setEnabled(true);
	 currentSyberLecturer=-1;
	 
	   this.m_table=table;	  
	   
	   btnSave.setVisible(true);
	   loadMode=false;
   }
  
   public void LoadCourseForReadOnly (CoursesController c)

   {
	   this.setTitle("פרטי קורס");
       frameTitel="פרטי קורס";
	   this.txtCourseId.setText(String.valueOf(c.GetCourseID()));
	   this.txtCourseId.setEnabled(false);
	   cmbDaysOfWeek.setSelectedIndex(c.GetCourseDayOfWeekID()-1);
	   cmbDaysOfWeek.setEnabled(false);
	   cmbCourseType.setSelectedIndex(c.GetCourseType()-1);
	   cmbCourseType.setEnabled(false);
	   this.dtpStartDate.setDate(c.GetCourseStartDate());
	   dtpStartDate.setEnabled(false);
	   this.dtpEndDate.setDate(c.GetCourseEndDate());
	   dtpEndDate.setEnabled(false);
	   this.dtpSystemStartDate.setDate(c.GetSystemStartDate());
	   dtpSystemStartDate.setEnabled(false);
	   this.dtpSystemEndDate.setDate(c.GetSystemEndDate());
	   dtpSystemEndDate.setEnabled(false);
	   this.dtpNetworkingStartDate.setDate(c.GetNetworkingStartDate());
	   dtpNetworkingStartDate.setEnabled(false);
	   this.dtpNetworkingEndDate.setDate(c.GetNetworkingEndDate());
	   dtpNetworkingEndDate.setEnabled(false);
	   this.dtpSyberStartDate.setDate(c.GetSyberStartDate());
	   dtpSyberStartDate.setEnabled(false);
	   this.dtpSyberEndDate.setDate(c.GetSyberEndDate());
	   dtpSyberEndDate.setEnabled(false);
	   this.dtpFinalTest.setDate(c.GetTestDate());
	   dtpFinalTest.setEnabled(false);
	  
	   for(int i=0;i< tableSpecializationInNetwork.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInNetwork.getValueAt(i,0).toString())==c.GetNetworkingLecturerID())
		   {
			   this.cmbNetworkingLecturer.setSelectedIndex(i); 
			   this.cmbNetworkingLecturer.setEnabled(false);
		   }
	   }
	 
	   for(int i=0;i< tableSpecializationInSystem.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInSystem.getValueAt(i,0).toString())==c.GetSystemLecturerID())
		   {
			   this.cmbSystemLecturer.setSelectedIndex(i);
			   this.cmbSystemLecturer.setEnabled(false);
		   }
	   }
	   
	   for(int i=0;i< tableSpecializationInSyber.getRowCount();i++)
	   {
		   if(Integer.parseInt(tableSpecializationInSyber.getValueAt(i,0).toString())==c.GetSyberLecturerID())
		   {
			   this.cmbSyberLecturer.setSelectedIndex(i); 
			   this.cmbSyberLecturer.setEnabled(false);
		   }
	   }
	   btnSave.setVisible(false);
	   loadMode=false;
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



	@SuppressWarnings({ "unchecked", "serial" })
	public AddOrEditCourseView() {
		
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 678);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		ImageIcon img = new ImageIcon("img/courseIcon.png");
		this.setIconImage(img.getImage());
		
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E7\u05D5\u05E8\u05E1:");
		lblNewLabel.setBounds(595, 36, 69, 14);
		contentPane.add(lblNewLabel);
		
		
		txtCourseId.setEditable(false);
		txtCourseId.setEnabled(false);
		txtCourseId.setBounds(450, 28, 139, 22);
		contentPane.add(txtCourseId);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E1\u05D5\u05D2 \u05E7\u05D5\u05E8\u05E1:");
		lblNewLabel_1.setBounds(605, 75, 69, 22);
		contentPane.add(lblNewLabel_1);
		
				
		 TableModel tmCourseTypes=this.coursesController.GetCourseTypes().getModel();
	     final JTable tableCourseTypes = new JTable(tmCourseTypes);
	     
	     Map<String,String> mapCourseTypes= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableCourseTypes.getRowCount())
		{
			mapCourseTypes.put(tableCourseTypes.getValueAt(i,0).toString(),tableCourseTypes.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelCourseTypes = new KeyValueComboboxModel();
		modelCourseTypes.putAll(mapCourseTypes);
		
        cmbCourseType = new JComboBox<Object>(modelCourseTypes);
    
        cmbCourseType.setRenderer(new DefaultListCellRenderer(){

            
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
        
        cmbCourseType.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbCourseType.getSelectedItem()!=null){
                	selectedCourseType= (KeyToString((java.util.Map.Entry<String, String>) cmbCourseType.getSelectedItem()));
                } else {
                	selectedCourseType=null;
                }
            }
        });
	

        cmbCourseType.setBackground(SystemColor.inactiveCaptionBorder);
		cmbCourseType.setBounds(422, 75, 167, 22);
		contentPane.add(cmbCourseType);
        	
		
		JLabel lblNewLabel_2 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4:");
		lblNewLabel_2.setBounds(584, 124, 90, 22);
		contentPane.add(lblNewLabel_2);
		
		
		dtpStartDate.setBounds(422, 124, 142, 22);
		dtpStartDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpStartDate);
		
		JLabel lblNewLabel_3 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD:");
		lblNewLabel_3.setBounds(287, 126, 75, 18);
		contentPane.add(lblNewLabel_3);
		
		
		dtpEndDate.setBounds(101, 124, 142, 22);
		dtpEndDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpEndDate);
		
		JLabel lblNewLabel_4 = new JLabel("\u05DE\u05E8\u05E6\u05D4 \u05DC\u05E8\u05E9\u05EA\u05D5\u05EA:");
		lblNewLabel_4.setBounds(583, 179, 81, 22);
		contentPane.add(lblNewLabel_4);
		
		
		 TableModel tmSpecializationInNetwork=this.lecturersController.GetLecturersForSpecializationInNetwork().getModel();
	     tableSpecializationInNetwork = new JTable(tmSpecializationInNetwork);
	     
	     Map<String,String> mapSpecializationInNetwork= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializationInNetwork.getRowCount())
		{
			mapSpecializationInNetwork.put(tableSpecializationInNetwork.getValueAt(i,0).toString(),tableSpecializationInNetwork.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecializationInNetwork = new KeyValueComboboxModel();
		modelSpecializationInNetwork.putAll(mapSpecializationInNetwork);
		
		cmbNetworkingLecturer = new JComboBox<Object>(modelSpecializationInNetwork);
    
        cmbNetworkingLecturer.setRenderer(new DefaultListCellRenderer(){

            
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
        
        cmbNetworkingLecturer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(cmbNetworkingLecturer.getSelectedItem()!=null){
                		selectedNetworkingLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbNetworkingLecturer.getSelectedItem()));
                		String curr=(KeyToString((java.util.Map.Entry<String, String>) cmbNetworkingLecturer.getItemAt(currentNetworkingLecturer)));
                if(lecturersController.IsLecturerActive(Integer.parseInt(selectedNetworkingLecturer))==true && selectedNetworkingLecturer!=curr)
                {
                		                	
                	
                	if(selectedNetworkingLecturer!=null  &&selectedNetworkingLecturer!="" &&txtCourseId.getText()!=null &&txtCourseId.getText()!="" 
                			&&selectedCourseType!=null &&selectedCourseType!="" && selectedDayOfWeek!=null  && selectedDayOfWeek!="" &&dtpStartDate.getDate()!=null  )
                	{
                	if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedNetworkingLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==true)
                	{
                		selectedNetworkingLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbNetworkingLecturer.getSelectedItem()));                  	
                	}
                	else
                	{
                		if(loadMode==false)
                    	{
                		 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
                		 cmbNetworkingLecturer.setSelectedIndex(currentNetworkingLecturer);
                 		selectedNetworkingLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbNetworkingLecturer.getSelectedItem()));                  	
                    	}
                	}
                	}
                } 
                           
                else
                {
                	//Integer.parseInt(selectedNetworkingLecturer)!=LoadedcoursesController.GetNetworkingLecturerID()
                	if(loadMode==false)
                	{
                	 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא אינו פעיל","הודעת מערכת",1);
                	 cmbNetworkingLecturer.setSelectedIndex(currentNetworkingLecturer);
             		selectedNetworkingLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbNetworkingLecturer.getSelectedItem()));   
                	}
              	
                }
                }
                else
                {
                	selectedNetworkingLecturer=null;
                }
              
            }
            
        });
        
	
		cmbNetworkingLecturer.setBackground(SystemColor.inactiveCaptionBorder);
		cmbNetworkingLecturer.setBounds(422, 179, 151, 22);
		contentPane.add(cmbNetworkingLecturer);
		
		JLabel lblNewLabel_5 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4 \u05E8\u05E9\u05EA\u05D5\u05EA:");
		lblNewLabel_5.setBounds(543, 221, 121, 22);
		contentPane.add(lblNewLabel_5);
		
		
		dtpNetworkingStartDate.setBounds(394, 221, 142, 22);
		dtpNetworkingStartDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpNetworkingStartDate);
		
		JLabel lblNewLabel_6 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD \u05E8\u05E9\u05EA\u05D5\u05EA:");
		lblNewLabel_6.setBounds(253, 221, 111, 22);
		contentPane.add(lblNewLabel_6);
		
	
		dtpNetworkingEndDate.setBounds(101, 221, 142, 22);
		dtpNetworkingEndDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpNetworkingEndDate);
		
		JLabel lblNewLabel_7 = new JLabel("\u05DE\u05E8\u05E6\u05D4 \u05DC\u05E1\u05D9\u05E1\u05D8\u05DD:");
		lblNewLabel_7.setBounds(583, 295, 81, 14);
		contentPane.add(lblNewLabel_7);
		

		 TableModel tmSpecializationInSystem=this.lecturersController.GetLecturersForSpecializationInSystem().getModel();
	      tableSpecializationInSystem = new JTable(tmSpecializationInSystem);
	     
	     Map<String,String> mapSpecializationInSystem= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializationInSystem.getRowCount())
		{
			mapSpecializationInSystem.put(tableSpecializationInSystem.getValueAt(i,0).toString(),tableSpecializationInSystem.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecializationInSystem = new KeyValueComboboxModel();
		modelSpecializationInSystem.putAll(mapSpecializationInSystem);
		
		cmbSystemLecturer = new JComboBox<Object>(modelSpecializationInSystem);
   
		cmbSystemLecturer.setRenderer(new DefaultListCellRenderer(){

           
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
       
       cmbSystemLecturer.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {   	   
               if(cmbSystemLecturer.getSelectedItem()!=null){
            	   selectedSystemLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSystemLecturer.getSelectedItem()));
           		String curr=(KeyToString((java.util.Map.Entry<String, String>) cmbSystemLecturer.getItemAt(currentSystemLecturer)));

             if(lecturersController.IsLecturerActive(Integer.parseInt(selectedSystemLecturer))==true)
                {
                   
               	if(selectedSystemLecturer!=null  &&selectedSystemLecturer!="" &&txtCourseId.getText()!=null &&txtCourseId.getText()!="" 
               			&&selectedCourseType!=null &&selectedCourseType!="" && selectedDayOfWeek!=null  && selectedDayOfWeek!="" &&dtpStartDate.getDate()!=null )
               	{
               	if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedSystemLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==true)
               	{
               		selectedSystemLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSystemLecturer.getSelectedItem()));                  	
               	}
               	else
               	{
               		if(loadMode==false)
               				{
               		 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
               		cmbSystemLecturer.setSelectedIndex(currentSystemLecturer);
               		selectedSystemLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSystemLecturer.getSelectedItem()));
               				}
               	}
               	}
               	
               }
             else
             {
            	 if(loadMode==false)
             	{
             	 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא אינו פעיל","הודעת מערכת",1);
             	cmbSystemLecturer.setSelectedIndex(currentSystemLecturer);
             	selectedSystemLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSystemLecturer.getSelectedItem()));
             	}
             	
             }
               	
               } else {
               	selectedSystemLecturer=null;
               }
           }
       });
       
		
		cmbSystemLecturer.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSystemLecturer.setBounds(422, 291, 151, 22);
		contentPane.add(cmbSystemLecturer);
		
		JLabel lblNewLabel_8 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4 \u05E1\u05D9\u05E1\u05D8\u05DD:");
		lblNewLabel_8.setBounds(543, 334, 121, 14);
		contentPane.add(lblNewLabel_8);
		
		
		dtpSystemStartDate.setBounds(394, 334, 142, 22);
		dtpSystemStartDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpSystemStartDate);
		
		JLabel lblNewLabel_9 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD \u05E1\u05D9\u05E1\u05D8\u05DD:");
		lblNewLabel_9.setBounds(253, 334, 110, 14);
		contentPane.add(lblNewLabel_9);
		
	
		dtpSystemEndDate.setBounds(101, 334, 142, 22);
		dtpSystemEndDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpSystemEndDate);
		
		JLabel lblNewLabel_10 = new JLabel("\u05DE\u05E8\u05E6\u05D4 \u05DC\u05E1\u05D9\u05D9\u05D1\u05E8:");
		lblNewLabel_10.setBounds(584, 407, 80, 14);
		contentPane.add(lblNewLabel_10);
		

		 TableModel tmSpecializationInSyber=this.lecturersController.GetLecturersForSpecializationInSyber().getModel();
	      tableSpecializationInSyber = new JTable(tmSpecializationInSyber);
	     
	     Map<String,String> mapSpecializationInSyber= new HashMap<String,String>(){{     
	        }};
	
		i=0;
		while (i<tableSpecializationInSyber.getRowCount())
		{
			mapSpecializationInSyber.put(tableSpecializationInSyber.getValueAt(i,0).toString(),tableSpecializationInSyber.getValueAt(i,1).toString());
			i++;
		}
		
		KeyValueComboboxModel modelSpecializationInSyber = new KeyValueComboboxModel();
		modelSpecializationInSyber.putAll(mapSpecializationInSyber);
		
		cmbSyberLecturer = new JComboBox<Object>(modelSpecializationInSyber);
   
		cmbSyberLecturer.setRenderer(new DefaultListCellRenderer(){

           
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
       
       cmbSyberLecturer.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if(cmbSyberLecturer.getSelectedItem()!=null){
            	   selectedSyberLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSyberLecturer.getSelectedItem()));
            		String curr=(KeyToString((java.util.Map.Entry<String, String>) cmbSyberLecturer.getItemAt(currentSyberLecturer)));
            	   if(lecturersController.IsLecturerActive(Integer.parseInt(selectedSyberLecturer))==true && selectedSyberLecturer!=curr)
                   {
                     
                  	if(selectedSyberLecturer!=null  &&selectedSyberLecturer!="" &&txtCourseId.getText()!=null &&txtCourseId.getText()!="" 
                  			&&selectedCourseType!=null &&selectedCourseType!="" && selectedDayOfWeek!=null  && selectedDayOfWeek!="" &&dtpStartDate.getDate()!=null )
                  	{
                  	if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedSyberLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==true)
                  	{
                  		selectedSyberLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSyberLecturer.getSelectedItem()));                  	
                  	}
                  	else
                  	{
                  		 if(loadMode==false)
                  		 {
                     	JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
                  		cmbSyberLecturer.setSelectedIndex(currentSyberLecturer);
                     	}
                  	}
                  	}
                  	selectedSyberLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSyberLecturer.getSelectedItem()));
                  	
                   }
            	   else
                   {
            		   if(loadMode==false)
                    	{
                   	 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה משום שהוא אינו פעיל","הודעת מערכת",1);
                   	cmbSyberLecturer.setSelectedIndex(currentSyberLecturer);
                   	selectedSyberLecturer= (KeyToString((java.util.Map.Entry<String, String>) cmbSyberLecturer.getSelectedItem()));
                    	}
                   	
                   }
            	   
                  } 
               
               else {
                  	selectedSyberLecturer=null;
                  }
           }
       });
       
		cmbSyberLecturer.setBackground(SystemColor.inactiveCaptionBorder);
		cmbSyberLecturer.setBounds(422, 403, 151, 22);
		contentPane.add(cmbSyberLecturer);
		
		JLabel lblNewLabel_11 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05EA\u05D7\u05DC\u05D4 \u05E1\u05D9\u05D9\u05D1\u05E8:");
		lblNewLabel_11.setBounds(543, 453, 121, 14);
		contentPane.add(lblNewLabel_11);
		
		
		dtpSyberStartDate.setBounds(394, 453, 142, 22);
		dtpSyberStartDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpSyberStartDate);
		
		JLabel lblNewLabel_12 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD \u05E1\u05D9\u05D9\u05D1\u05E8:");
		lblNewLabel_12.setBounds(264, 453, 97, 14);
		contentPane.add(lblNewLabel_12);
		
		
		dtpSyberEndDate.setBounds(101, 453, 142, 22);
		dtpSyberEndDate.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpSyberEndDate);
		
		JLabel lblNewLabel_13 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DE\u05D1\u05D7\u05DF \u05DE\u05E1\u05DB\u05DD:");
		lblNewLabel_13.setBounds(553, 536, 111, 14);
		contentPane.add(lblNewLabel_13);
		
	
		dtpFinalTest.setBounds(394, 528, 142, 22);
		dtpFinalTest.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dtpFinalTest);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 605, 167, 33);
		contentPane.add(panel);
		
	
	
		
		btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 boolean res=false;
	            	 
	            	 
	            	 
	            	     if(selectedCourseType==null || cmbCourseType.getSelectedIndex()==-1)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך לבחור סוג קורס","הודעת מערכת",1);
	                      	return;
	            	     }
	            	 
	            	     
	            	     if(selectedDayOfWeek==null || cmbDaysOfWeek.getSelectedIndex()==-1)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך לבחור יום בשבוע","הודעת מערכת",1);
	                      	return;
 
	            	     }
	            	     
	            	
	            	     if(dtpStartDate.getDate()==null ||dtpEndDate.getDate()==null ||dtpSystemStartDate.getDate()==null||dtpSystemEndDate.getDate()==null||
	            	    		 dtpNetworkingStartDate.getDate()==null||dtpNetworkingEndDate.getDate()==null|| dtpSyberStartDate.getDate()==null||dtpSyberEndDate.getDate()==null ||dtpFinalTest.getDate()==null)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך למלא את כל התאריכים","הודעת מערכת",1);
	                      	return;
	            	     }
	            	 
	            	 
	            	     if(selectedNetworkingLecturer==null || cmbDaysOfWeek.getSelectedIndex()==-1)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך לבחור מרצה לרשתות","הודעת מערכת",1);
	                      	return;
 
	            	     }
	            	     
	            	     if(selectedSystemLecturer==null || cmbDaysOfWeek.getSelectedIndex()==-1)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך לבחור מרצה לסיסטם","הודעת מערכת",1);
	                      	return;
 
	            	     }
	            	     
	            	     if(selectedSyberLecturer==null || cmbDaysOfWeek.getSelectedIndex()==-1)
	            	     {
	                  		 JOptionPane.showMessageDialog(null,"עליך לבחור מרצה לסייבר","הודעת מערכת",1);
	                      	return;
 
	            	     }
	            	     
	            	     if(dtpEndDate.getDate().before(dtpStartDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך סיום הקורס צריך להיות גדול מתאריך התחלתו","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpNetworkingEndDate.getDate().before(dtpNetworkingStartDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך סיום רשתות צריך להיות גדול מתאריך התחלתו","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpSystemEndDate.getDate().before(dtpSystemStartDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך סיום סיסטם צריך להיות גדול מתאריך התחלתו","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpSyberEndDate.getDate().before(dtpSyberStartDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך סיום סייבר צריך להיות גדול מתאריך התחלתו","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpSystemStartDate.getDate().before(dtpNetworkingEndDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך תחילת סיסטם צריך להיות גדול מתאריך סיום רשתות","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpSyberStartDate.getDate().before(dtpSystemEndDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך תחילת סייבר צריך להיות גדול מתאריך סיום סיסטם","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpFinalTest.getDate().before(dtpSyberEndDate.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך המבחן צריך להיות גדול מתאריך סיום סייבר","הודעת מערכת",1);
		                      	return;
	            	     }
	            	     
	            	     if(dtpEndDate.getDate().before(dtpFinalTest.getDate()))
	            	     {
	            	    	 JOptionPane.showMessageDialog(null,"תאריך הסיום צריך להיות גדול מתאריך המבחן הסופי","הודעת מערכת",1);
		                      	return;
	            	     } 
	            	     
	                	if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedNetworkingLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==false)
	                	{
	                  		 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה לרשתות משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
	                  		return;
	                	}
	            	 
	                	if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedSystemLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==false)
	                	{
	                  		 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה לסיסטם משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
	                  		return;
	                	}
	            	 
	            	 
	            	 
	            		if(lecturersController.CheckIfLecturerIsValid(Integer.parseInt(selectedSyberLecturer),Integer.parseInt(txtCourseId.getText()), Integer.parseInt(selectedCourseType), Integer.parseInt(selectedDayOfWeek), dtpStartDate.getDate())==false)
	            		{
	                  		 JOptionPane.showMessageDialog(null,"אינך יכול לבחור במרצה זה לסייבר  משום שהוא רשום לקורס אחר בטווח הזה.","הודעת מערכת",1);
	                  		return;
	            		}
	            	 
	            	 
	            	 
	            	 
	            		CoursesController cs= new CoursesController(Integer.parseInt(txtCourseId.getText()),Integer.parseInt(selectedCourseType),dtpStartDate.getDate(),dtpEndDate.getDate(),Integer.parseInt(selectedDayOfWeek),Integer.parseInt(selectedNetworkingLecturer), Integer.parseInt(selectedSystemLecturer),Integer.parseInt(selectedSyberLecturer),dtpNetworkingStartDate.getDate()
		            			 ,dtpSystemStartDate.getDate(),dtpSyberStartDate.getDate(),dtpNetworkingEndDate.getDate(),dtpSystemEndDate.getDate(), dtpSyberEndDate.getDate(),dtpFinalTest.getDate());
		            	 
	            	 
	            	if(frameTitel=="עריכת קורס")
	            	{
	                res=coursesController.SetCourseData(cs);
	            	}
	            	else
	            	{
	            		 res=coursesController.InsertNewCourse(cs);
	            	}
	               
	               if(res==true)
	               {
	            	   JOptionPane.showMessageDialog(null,"השמירה בוצעה בהצלחה!","הודעת מערכת",1);
	            	   DefaultTableModel  tm=(DefaultTableModel) coursesController.GetData().getModel();
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
	        	       
	            	   m_table.getColumnModel().getColumn(numOfCol-5).setWidth(0);
	            	   m_table.getColumnModel().getColumn(numOfCol-5).setMinWidth(0);
	            	   m_table.getColumnModel().getColumn(numOfCol-5).setMaxWidth(0);
	        	       
	            	            	   
	               }
	               else
	               {
	            	   JOptionPane.showMessageDialog(null,"ישנה תקלה בשמירת השינויים,אנא פנה למנהל המערכת.","הודעת מערכת",1);
	            	   
	               }
	               
	            }
	        });
		panel.add(btnSave);
		
		JLabel lblNewLabel_14 = new JLabel("יום בשבוע:");
		lblNewLabel_14.setBounds(294, 79, 56, 14);
		contentPane.add(lblNewLabel_14);
		
		 TableModel tmDaysOfWeek=this.coursesController.GetDaysOfWeek().getModel();
	     final JTable tableDaysOfWeek = new JTable(tmDaysOfWeek);
	     
	     Map<String,String> mapDaysOfWeek= new HashMap<String,String>(){{     
	        }};
	
		int j=0;
		while (j<tableDaysOfWeek.getRowCount())
		{
			mapDaysOfWeek.put(tableDaysOfWeek.getValueAt(j,0).toString(),tableDaysOfWeek.getValueAt(j,1).toString());
			j++;
		}
		
		KeyValueComboboxModel modelDaysOfWeek = new KeyValueComboboxModel();
		modelDaysOfWeek.putAll(mapDaysOfWeek);
		
        cmbDaysOfWeek = new JComboBox<Object>(modelDaysOfWeek);
    
        cmbDaysOfWeek.setRenderer(new DefaultListCellRenderer(){

          
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
        
    	cmbDaysOfWeek.setBounds(76, 75, 167, 22);
		
		contentPane.add(cmbDaysOfWeek);
	
		cmbDaysOfWeek.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                if(cmbDaysOfWeek.getSelectedItem()!=null){
	                	selectedDayOfWeek= (KeyToString((java.util.Map.Entry<String, String>) cmbDaysOfWeek.getSelectedItem()));
	                } else {
	                	selectedDayOfWeek=null;
	                }
	            }
	        });
		
		

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
