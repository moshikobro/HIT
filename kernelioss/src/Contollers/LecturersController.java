package Contollers;

import java.util.Date;

import javax.swing.JTable;

import Models.Course;
import Models.Lecturer;

public class LecturersController {
	Lecturer model;

	
	public LecturersController(){
	    this.model = new  Lecturer();
	}
	
	public LecturersController(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate,
			int specializationID_1,int specializationID_2,int specializationID_3,int status) {
		
		  this.model = new  Lecturer( firstName, lastName, ID, address, PhoneNumber, birthDate,
					 specializationID_1, specializationID_2, specializationID_3,status);
	}
	

	public JTable GetData()
	{
		return this.model.GetLecturersData();
	}
	
	public JTable GetLecturersForSpecializationInNetwork()
	{
		return this.model.GetLecturersForSpecializationInNetwork();
	}
	public JTable GetLecturersForSpecializationInSyber()
	{
		return this.model.GetLecturersForSpecializationInSyber();
	}
	public JTable GetLecturersForSpecializationInSystem()
	{
		return this.model.GetLecturersForSpecializationInSystem();
	}
	public Boolean CheckIfLecturerIsValid (int seq ,int courseID,int courseType,int dayInWeek,Date courseEndDate)
	{
		if(courseEndDate==null)
			return false;
		return this.model.CheckIfLecturerIsValid ( seq , courseID, courseType, dayInWeek, courseEndDate);
	}
	
	public Boolean CanBeDeleted (String lecturerID)
	{
		if(lecturerID==null)
			return true;
		return this.model.CanBeDeleted(lecturerID);	   
	}
	
	public Boolean DeleteLecturer (String lecturerID)
	{
		if(lecturerID==null)
			return false;
		return this.model.DeleteLecturer(lecturerID);
	}
	
	public Boolean IsLecturerActive (int lecturerSeqID)
	{
		return this.model.IsLecturerActive(lecturerSeqID);
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
	public int GetStatus()
	{
		return this.model.GetStatus();
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
	
	public int GetSpecializationID_1()
	{
		return this.model.GetSpecializationID_1();
	}
	
	public int GetSpecializationID_2()
	{
		return this.model.GetSpecializationID_2();
	}
	
	public int GetSpecializationID_3()
	{
		return this.model.GetSpecializationID_3();
	}
	
	 public JTable GetSpecializations()
	 {
		 return this.model.GetSpecializations();		
	 }
	 
	 public JTable GetStatuses()
	 {
		 return this.model.GetStatuses();		
	 }
	
	public Boolean IsLecturerExists (String lecturerID)
	{
		if(lecturerID==null)
			return false;
		return this.model.IsLecturerExists(lecturerID);
	}
	
	public Boolean SetLecturerData (LecturersController l)
	{
		return this.model.SetLecturerData(l.getModel());
	}
		
	
	 public Lecturer getModel()
	 {
		 return this.model;
	 }
	 
	public Boolean InsertNewLecturer (LecturersController l)
	{
		return this.model.InsertNewLecturer(l.getModel());
	}
		
	 
	}
	
	

