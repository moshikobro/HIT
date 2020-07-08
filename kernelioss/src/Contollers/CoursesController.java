package Contollers;


import java.util.Date;


import javax.swing.JTable;

import Models.Course;
import Models.Student;


public class CoursesController  {
	Course model;

		
	public CoursesController(){
	    this.model = new  Course();
	}
	
	public CoursesController(int courseID,int courseType,Date startDate,Date endDate,int  dayOfWeekID,int  networkingLecturerID,int  systemLecturerID,int  syberLecturerID,
			Date networkingStartDate,Date systemStartDate,Date syberStartDate,Date networkingEndDate,Date systemEndDate, Date  syberEndDate, Date  testDate	) {
		
		  this.model = new  Course(courseID, courseType, startDate, endDate,  dayOfWeekID,  networkingLecturerID,  systemLecturerID,  syberLecturerID,
					 networkingStartDate, systemStartDate, syberStartDate, networkingEndDate, systemEndDate,   syberEndDate,   testDate	);
	}
	 public Course getModel()
	 {
		 return this.model;
	 }
		
	public JTable GetData()
	{
		return this.model.GetCourseData();
	}


	public Boolean SetCourseData (CoursesController c)
	{
		if(this.model.SetCourseData(c.getModel())==true)
	          return true;
		
		return false;
	}
	
	public Boolean InsertNewCourse (CoursesController c)
	{
		if(this.model.InsertNewCourse(c.getModel())==true)
	          return true;
		
		return false;
	}
	
	public boolean DeleteCourse(int courseID)
	{
		return this.model.DeleteCourse(courseID);
	}
	
	public JTable GetDaysOfWeek()
	{
		return this.model.GetDaysOfWeek();
	}
	
	public int GetNextCourseNumber()
	{
		return this.model.GetNextCourseNumber();
	}
	
	public JTable GetCourseTypes()
	{
		return this.model.GetCourseTypes();
	}
	
	 public int GetCourseID()
	    {
	    	return this.model.GetCourseID();
	    }
	    
	    public int GetCourseType()
	    {
	    	return this.model.GetCourseType();
	    }
	    
	    public Date GetCourseStartDate()
	    {
	    	return this.model.GetCourseStartDate();
	    }
	    
	    public Date GetCourseEndDate()
	    {
	    	return this.model.GetCourseEndDate();
	    }
	    
	    public int GetCourseDayOfWeekID()
	    {
	    	return this.model.GetCourseDayOfWeekID();
	    }
	    public String GetCourseDayOfWeekDesc()
	    {
	    	return this.model.GetCourseDayOfWeekDesc();
	    }
	    
	    public String GetCourseNetworkingLecturer()
	    {
	    	return this.model.GetCourseNetworkingLecturer();
	    }
	    
	    public String GetCourseSystemLecturer()
	    {
	    	return this.model.GetCourseSystemLecturer();
	    }
	    
	    public String GetCourseSyberLecturer()
	    {
	    	return this.model.GetCourseSyberLecturer();
	    }
	    
	    
	    public Date GetNetworkingStartDate()
	    {
	    	return this.model.GetNetworkingStartDate();
	    }
	    
	    public Date GetNetworkingEndDate()
	    {
	    	return this.model.GetNetworkingEndDate();
	    }
	    
	    
	    public Date GetSystemStartDate()
	    {
	    	return this.model.GetSystemStartDate();
	    }
	    
	    public Date GetSystemEndDate()
	    {
	    	return this.model.GetSystemEndDate();
	    }
	    	        
	    public Date GetSyberStartDate()
	    {
	    	return this.model.GetSyberStartDate();
	    }   
	    public Date GetSyberEndDate()
	    {
	    	return this.model.GetSyberEndDate();
	    }
	    	    
	    public Date GetTestDate()
	    {
	    	return this.model.GetTestDate();
	    }
	    
	    public String GetTypeDesc()
	    {
	    	return this.model.GetTypeDesc();
	    }
	    public int GetNetworkingLecturerID()
	    {
	    	return this.model.GetNetworkingLecturerID();
	    }
	    public int GetSystemLecturerID()
	    {
	    	return this.model.GetSystemLecturerID();
	    }
	    public int GetSyberLecturerID()
	    {
	    	return this.model.GetSyberLecturerID();
	    }
	    
	    public JTable GetStudentsInCourse(int courseID)
	    {
	    	return this.model.GetStudentsInCourse(courseID);
	    }
	    
	    public JTable GetCoursesForStudents()
	    {
	    	return this.model.GetCoursesForStudents();
	    }
	    
	    public boolean IsCourseEnded(int courseID)
	    {
	    	return this.model.IsCourseEnded(courseID);
	    }
	    
	    public boolean IsCourseHaveStudents(int courseID)
	    {
	      	return this.model.IsCourseHaveStudents(courseID);
	    }
	    
	 public boolean AddStudentToCourse(String StudentID,int courseID)
	 {
		 return this.model.AddStudentToCourse(StudentID,courseID);
	 }
		
	
}



