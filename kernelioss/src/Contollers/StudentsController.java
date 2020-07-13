package Contollers;

import java.util.Date;
import java.util.Observable;

import javax.swing.JTable;


import Models.Student;



public class StudentsController  extends  Observable{
	Student model;

	
	public StudentsController(){
	    this.model = new  Student();
	}
	
	public StudentsController(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate,int grade) {
		
		  this.model = new  Student( firstName, lastName, ID, address, PhoneNumber, birthDate,grade);
	}
	
	public String GetfirstName()
	{
		return this.model.GetfirstName();

	}
	public String GetLastName()
	{
		return this.model.GetLastName();
	}
	public String GetID()
	{
		return this.model.GetID();
	}
	public String GetAddress()
	{
		return this.model.GetAddress();
	}
	public String GetPhoneNumber()
	{
		return this.model.GetPhoneNumber();
	}
	public Date GetbirthDate()
	{
		return this.model.GetbirthDate();
	}
	
	
	public int GetGrade()
	{
		return this.model.GetGrade();
	}
	
	public JTable GetData()
	{
		return this.model.GetStudentsData();
	}
	
	public Student getModel()
	 {
		 return this.model;
	 }
	 
	public Boolean InsertNewStudent (StudentsController s,int courseID)
	{
		boolean res= this.model.InsertNewStudent(s.getModel(),courseID);
		int [] arr =new int[] {Integer.parseInt(s.getModel().GetID()),courseID};
		setChanged();
		notifyObservers(arr);
		return	res;
	}
		
	 


	public Boolean SetStudentData (StudentsController s,int courseID)
	{
		return this.model.SetStudentData(s.getModel(),courseID);		
	}
	   
	
	public Boolean IsStudentExists (String studentID)
	{
		if(studentID==null)
		{
			return false;
		}
		return this.model.IsStudentExists(studentID);		
	}
	   
	
	
	public Boolean DeleteStudent (String studentID)
	{
		if(studentID==null)
		{
			return false;
		}
		return this.model.DeleteStudent(studentID);
	}
	
	}
