package Contollers;

import java.util.Date;

import javax.swing.JTable;

import Models.Lecturer;

public class LecturersController {
	Lecturer model;

	
	public LecturersController(){
	    this.model = new  Lecturer();
	}
	

	public JTable GetData()
	{
		return this.model.GetLecturersData();
	}

	//public boolean DeleteCourse(int LecturerID)
	//{
	//	return this.model.DeleteLecturer(LecturerID);
	//}
	
	
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
		return this.model.CheckIfLecturerIsValid ( seq , courseID, courseType, dayInWeek, courseEndDate);
	}
	
	}
	
	

