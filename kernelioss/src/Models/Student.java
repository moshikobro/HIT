package Models;

import java.util.Date;

import javax.swing.JTable;

public class Student extends Customer {
	
	private StudentRepository StudentRepository = new StudentRepository();
	private Customer Customer;
	private int grade;

	
	public Student(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate,int grade) {
		this.Customer = new Customer( firstName, lastName, ID, address, PhoneNumber, birthDate);
		this.grade=grade;		
	}
	
	public Student()
	{
		
	}
	@Override
	public String GetfirstName()
	{
		return this.Customer.GetfirstName();

	}
	@Override
	public String GetLastName()
	{
		return this.Customer.GetLastName();
	}
	@Override
	public String GetID()
	{
		return this.Customer.GetID();
	}
	@Override
	public String GetAddress()
	{
		return this.Customer.GetAddress();
	}
	@Override
	public String GetPhoneNumber()
	{
		return this.Customer.GetPhoneNumber();
	}
	@Override
	public Date GetbirthDate()
	{
		return this.Customer.GetbirthDate();
	}
	
	
	public int GetGrade()
	{
		return this.grade;
	}
	
	public JTable GetStudentsData()
	{
		return this.StudentRepository.GetStudentsData();
	}
	
	
	public Boolean SetStudentData (Student s,int courseID)
	{
		return this.StudentRepository.SetStudentDetails(s,courseID);	
	}
	   
		
	public Boolean DeleteStudent (String StudentID)
	{
		return this.StudentRepository.DeleteStudent(StudentID);
	}
	
	public Boolean IsStudentExists (String studentID)
	{
		return this.StudentRepository.IsStudentExists(studentID);		
	}
	
	
	
	public Boolean InsertNewStudent (Student s,int courseID)
	{
		return this.StudentRepository.InsertNewStudent(s,courseID);
	}
	
	
}
