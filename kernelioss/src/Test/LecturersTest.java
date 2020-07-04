package Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contollers.LecturersController;
import Contollers.StudentsController;

class LecturersTest {


	
	@Test
	void CheckIfLecturerIsValidTest() {
		LecturersController lc = new LecturersController();
		
		String s=null;		
		  try {
			  lc.CheckIfLecturerIsValid(Integer.parseInt(s),Integer.parseInt(s),Integer.parseInt(s),Integer.parseInt(s),null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void CheckIfLecturerIsValidTest_2() {
		LecturersController lc = new LecturersController();
		
		String s=null;		
		  try {
			  lc.CheckIfLecturerIsValid(-1,Integer.parseInt(s),Integer.parseInt(s),Integer.parseInt(s),null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void CheckIfLecturerIsValidTest_3() {
		LecturersController lc = new LecturersController();
		
		String s=null;		
		  try {
			  lc.CheckIfLecturerIsValid(Integer.parseInt(s),-1,Integer.parseInt(s),Integer.parseInt(s),null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void CheckIfLecturerIsValidTest_4() {
		LecturersController lc = new LecturersController();
		
				
		  try {
			  lc.CheckIfLecturerIsValid(-1,-1,-1,-1,null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void CanBeDeletedTest() {
		LecturersController lc = new LecturersController();
		
				
		  try {
			  lc.CanBeDeleted(null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void DeleteLecturerTest() {
		LecturersController lc = new LecturersController();
		
				
		  try {
			  lc.DeleteLecturer(null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void IsLecturerActiveTest() {
		LecturersController lc = new LecturersController();
		
		String s=null;
		  try {
			  lc.IsLecturerActive(Integer.parseInt(s));
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void IsLecturerExistsTest() {
		LecturersController lc = new LecturersController();
		
		
		  try {
			  lc.IsLecturerExists(null);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void SetLecturerDataTest() {
		LecturersController lc = new LecturersController();
		LecturersController lc2=null;
		
		  try {
			  lc.SetLecturerData(lc2);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
	@Test
	void InsertNewLecturerTest() {
		LecturersController lc = new LecturersController();
		LecturersController lc2=null;
		
		  try {
			  lc.InsertNewLecturer(lc2);
			    fail("Expected an IllegalArgumentException to be thrown");
			  } catch (IllegalArgumentException e ) {
				  System.out.print(e.getMessage());
			  }
			}
}

