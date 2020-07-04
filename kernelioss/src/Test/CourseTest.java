package Test;

import static org.junit.Assert.fail;

import  org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contollers.CoursesController;

class CourseTest {
	
	@Test
	void DeleteCourseTest() {
		CoursesController cs = new CoursesController();
		String s=null;		
		  try {
			  cs.DeleteCourse(Integer.parseInt(s));
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	

@Test
void IsCourseHaveStudentsTest() {
	CoursesController cs = new CoursesController();
	String s=null;		
	  try {
		  cs.IsCourseHaveStudents(Integer.parseInt(s));
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}


@Test
void IsCourseHaveStudentsTest_2() {
	CoursesController cs = new CoursesController();
	String s="";		
	  try {
		  cs.IsCourseHaveStudents(Integer.parseInt(s));
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}


@Test
void GetStudentsInCourseTest() {
	CoursesController cs = new CoursesController();
	String s="";		
	  try {
		  cs.GetStudentsInCourse(Integer.parseInt(s));
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}

@Test
void GetStudentsInCourseTest_2() {
	CoursesController cs = new CoursesController();
	String s=null;		
	  try {
		  cs.GetStudentsInCourse(Integer.parseInt(s));
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}

@Test
void InsertNewCourseTest() {
	CoursesController cs = new CoursesController();
	CoursesController c=null;
	//String s=null;		
	  try {
		  cs.InsertNewCourse(c);
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}
@Test
void SetCourseDataTest() {
	CoursesController cs = new CoursesController();
	CoursesController c=null;
	//String s=null;		
	  try {
		  cs.SetCourseData(c);
		    fail("Expected an IllegalArgumentException to be thrown");
		  } catch (IllegalArgumentException e ) {
			  System.out.print(e.getMessage());
		  }
		}






}




