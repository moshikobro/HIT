package Contollers;


import javax.swing.JTable;

import Models.Course;


public class CoursesController  {
	Course model;

		
	public CoursesController(){
	    this.model = new  Course();
	}
	

	public JTable GetData()
	{
		return this.model.GetCourseData();
	}

}



