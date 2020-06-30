package Models;


import java.util.*;

import javax.swing.JTable;
import Models.CourseRepository;

public class Course {
	
private CourseRepository courseRepository = new CourseRepository();
private int  corseID;
private int  corseType;
private Date startDate;
private Date endDate;
private int  dayOfWeekID;
private String  networkingLecturer;
private String  systemLecturer;
private String  syberLecturer;
private Date networkingStartDate;
private Date systemStartDate;
private Date syberStartDate;
private Date networkingEndDate;
private Date systemEndDate;
private Date  syberEndDate;
private Date  testDate;
private String TypeDesc;
private int  networkingLecturerID;
private int  systemLecturerID;
private int  syberLecturerID;
private String dayOfWeekDesc;

							
public Course(int courseID,int courseType,Date startDate,Date endDate,int  dayOfWeekID,int  networkingLecturerID,int  systemLecturerID,int  syberLecturerID,
		Date networkingStartDate,Date systemStartDate,Date syberStartDate,Date networkingEndDate,Date systemEndDate, Date  syberEndDate, Date  testDate		) {
	
this.corseID=courseID;
this.corseType=courseType;
this.startDate=startDate;
this.endDate=endDate;
this.dayOfWeekID=dayOfWeekID;
this.networkingLecturerID=networkingLecturerID;
this.systemLecturerID=systemLecturerID;
this.syberLecturerID=syberLecturerID;
this.networkingStartDate=networkingStartDate;
this.systemStartDate=systemStartDate;
this.syberStartDate=syberStartDate;
this.networkingEndDate=networkingEndDate;
this.systemEndDate=systemEndDate;
this.syberEndDate=syberEndDate;
this.testDate=testDate;

}

public Course()
{
	this.corseID=-1;
	this.corseType=1;
	this.startDate=new Date();
	this.endDate=new Date();
	this.dayOfWeekID=1;
	this.networkingLecturer="";
	this.systemLecturer="";
	this.syberLecturer="";
	this.networkingStartDate=new Date();
	this.systemStartDate=new Date();
	this.syberStartDate=new Date();
	this.networkingEndDate=new Date();
	this.systemEndDate=new Date();
	this.syberEndDate=new Date();
	this.testDate=new Date();
	this.TypeDesc="";
	this.networkingLecturerID=0;
	this.systemLecturerID=0;
	this.syberLecturerID=0;

}
	
	
	public Boolean SetCourseData (Course c)
	{
		if(this.courseRepository.SetCourse(c)==true)
	          return true;
		
		return false;
	}
	
	
    public JTable GetCourseData()
    {
    	return  this.courseRepository.GetCourseData();
    }
  
    public int GetCourseID()
    {
    	return this.corseID;
    }
    
    public int GetCourseType()
    {
    	return this.corseType;
    }
    
    public Date GetCourseStartDate()
    {
    	return this.startDate;
    }
    
    public Date GetCourseEndDate()
    {
    	return this.endDate;
    }
    
    public int GetCourseDayOfWeekID()
    {
    	return this.dayOfWeekID;
    }
    public String GetCourseDayOfWeekDesc()
    {
    	return this.dayOfWeekDesc;
    }
    
    public String GetCourseNetworkingLecturer()
    {
    	return this.networkingLecturer;
    }
    
    public String GetCourseSystemLecturer()
    {
    	return this.systemLecturer;
    }
    
    public String GetCourseSyberLecturer()
    {
    	return this.syberLecturer;
    }
    
    
    public Date GetNetworkingStartDate()
    {
    	return this.networkingStartDate;
    }
    
    public Date GetNetworkingEndDate()
    {
    	return this.networkingEndDate;
    }
    
    
    public Date GetSystemStartDate()
    {
    	return this.systemStartDate;
    }
    
    public Date GetSystemEndDate()
    {
    	return this.systemEndDate;
    }
    
        
    public Date GetSyberStartDate()
    {
    	return this.syberStartDate;
    }
    
    public Date GetSyberEndDate()
    {
    	return this.syberEndDate;
    }
    
    
    public Date GetTestDate()
    {
    	return this.testDate;
    }
    
    public String GetTypeDesc()
    {
    	return this.TypeDesc;
    }
    public int GetNetworkingLecturerID()
    {
    	return this.networkingLecturerID;
    }
    public int GetSystemLecturerID()
    {
    	return this.systemLecturerID;
    }
    public int GetSyberLecturerID()
    {
    	return this.syberLecturerID;
    }
    
    public Boolean DeleteCourse (int courseID) {
    	if(this.courseRepository.DeleteCourse(courseID)==true)
	          return true;
		
		return false;
    }
    
    public JTable GetDaysOfWeek()
    {
    	return this.courseRepository.GetDaysOfWeek();
    }
       
    
    public int GetNextCourseNumber()
    {
    	return this.courseRepository.GetNextCourseNumber();
    }
    
    
    public JTable GetCourseTypes()
    {
    	return this.courseRepository.GetCourseTypes();
    }
    
    public boolean InsertNewCourse(Course c)
    {
    	return this.courseRepository.InsertNewCourse(c);
    }
    
    public JTable GetStudentsInCourse(int courseID)
    {
    	return this.courseRepository.GetStudentsInCourse(courseID);
    }
    
   }
    	 

