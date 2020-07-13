package Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contollers.CoursesController;
import Contollers.StudentsController;

class StudentsTest {

	@Test
	void InsertNewStudentTest() {
		StudentsController sc = new StudentsController();
		
		String s=null;		
		  try {
			  sc.InsertNewStudent(sc,Integer.parseInt(s));
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}

	@Test
	void SetStudentDataTest() {
		StudentsController sc = new StudentsController();
		
		String s=null;		
		  try {
			  sc.SetStudentData(sc,Integer.parseInt(s));
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void IsStudentExistsTest() {
		StudentsController sc = new StudentsController();
		
		String s=null;		
		  try {
			  sc.IsStudentExists(s);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}

	@Test
	void DeleteStudentTest() {
		StudentsController sc = new StudentsController();
		
		String s=null;		
		  try {
			  sc.DeleteStudent(s);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}

}
