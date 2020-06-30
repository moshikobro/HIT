package Models;

import java.util.Date;

import javax.swing.JTable;

import Models.LecturerRepository;
public class Lecturer extends Person {
	
	private LecturerRepository lecturerRepository = new LecturerRepository();
	private Person Person;
	private int specializationID_1;
	private int specializationID_2;
	private int specializationID_3;

	
	public Lecturer(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate,
			int specializationID_1,int specializationID_2,int specializationID_3) {
		this.Person = new Person( firstName, lastName, ID, address, PhoneNumber, birthDate);
		this.specializationID_1=specializationID_1;
		this.specializationID_2=specializationID_2;
		this.specializationID_3=specializationID_3;

		
	}
	public Lecturer()
	{
		
	}
	
	public String GetfirstName()
	{
		return this.Person.GetfirstName();

	}
	public String GetLastName()
	{
		return this.Person.GetLastName();
	}
	public String GetID()
	{
		return this.Person.GetID();
	}
	public String GetAddress()
	{
		return this.Person.GetAddress();
	}
	public String GetPhoneNumber()
	{
		return this.Person.GetPhoneNumber();
	}
	public Date GetbirthDate()
	{
		return this.Person.GetbirthDate();
	}
	
	public int GetSpecializationID_1()
	{
		return this.specializationID_1;
	}
	
	public int GetSpecializationID_2()
	{
		return this.specializationID_2;
	}
	
	public int GetSpecializationID_3()
	{
		return this.specializationID_3;
	}
	
	public JTable GetLecturersData()
	{
		return this.lecturerRepository.GetLecturersData();
	}
	
	public JTable GetLecturersForSpecializationInNetwork()
	{
		return this.lecturerRepository.GetLecturersForSpecializationInNetwork();
	}
	public JTable GetLecturersForSpecializationInSyber()
	{
		return this.lecturerRepository.GetLecturersForSpecializationInSyber();
	}
	public JTable GetLecturersForSpecializationInSystem()
	{
		return this.lecturerRepository.GetLecturersForSpecializationInSystem();
	}
	public Boolean SetLecturersDetails (Lecturer l)
	{
	//	if(this.LecturerRepository.SetCourse(l)==true)
		//	LecturerRepository
	   //       return true;
		
	//
		return false;
	}
	
	
	public Boolean CheckIfLecturerIsValid (int seq ,int courseID,int courseType,int dayInWeek,Date courseEndDate)
	{
		if(this.lecturerRepository.CheckIfLecturerIsValid(seq , courseID, courseType, dayInWeek, courseEndDate)==true)
	          return true;
		
		return false;
	}
	
}
