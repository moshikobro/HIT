package Contollers;


import java.util.Observable;
import java.util.Observer;

public class CourseObserver implements Observer{
	CoursesController cs=new CoursesController();
   
	@Override
	public void update(Observable o, Object arg) {
		int[] arr = (int[]) arg;
		this.cs.AddStudentToCourse(String.valueOf(arr[0]),arr[1]);
		
	}
}
