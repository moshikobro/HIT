package Models;

import java.util.Date;

import javax.swing.JTable;

import Models.LecturerRepository;
public class Lecturer extends Worker {
	
	private LecturerRepository lecturerRepository = new LecturerRepository();
	private Worker Worker;
	private int specializationID_1;
	private int specializationID_2;
	private int specializationID_3;
	private int status;

	
	public Lecturer(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate,
			int specializationID_1,int specializationID_2,int specializationID_3,int status) {
		this.Worker = new Worker( firstName, lastName, ID, address, PhoneNumber, birthDate);
		this.specializationID_1=specializationID_1;
		this.specializationID_2=specializationID_2;
		this.specializationID_3=specializationID_3;
		this.status=status;		
	}
	
	public Lecturer()
	{
		
	}
	@Override
	public String GetfirstName()
	{
		return this.Worker.GetfirstName();

	}
	@Override
	public String GetLastName()
	{
		return this.Worker.GetLastName();
	}
	@Override
	public String GetID()
	{
		return this.Worker.GetID();
	}
	@Override
	public String GetAddress()
	{
		return this.Worker.GetAddress();
	}
	@Override
	public String GetPhoneNumber()
	{
		return this.Worker.GetPhoneNumber();
	}
	@Override
	public Date GetbirthDate()
	{
		return this.Worker.GetbirthDate();
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
	
	public int GetStatus()
	{
		return this.status;
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
	public Boolean SetLecturerData (Lecturer l)
	{
		return this.lecturerRepository.SetLecturerDetails(l);		
	}
	
	 public JTable GetSpecializations()
	 {
		 return this.lecturerRepository.GetSpecializations();		
	 }
	 
	 public JTable GetStatuses()
	 {
		 return this.lecturerRepository.GetStatuses();		
	 }
	    
	public Boolean CheckIfLecturerIsValid (int seq ,int courseID,int courseType,int dayInWeek,Date courseEndDate)
	{
		return this.lecturerRepository.CheckIfLecturerIsValid(seq , courseID, courseType, dayInWeek, courseEndDate);

	}
	
	public Boolean CanBeDeleted (String lecturerID)
	{
		return this.lecturerRepository.CanBeDeleted(lecturerID);
	
	}
	public Boolean IsLecturerActive (int lecturerSeqID)
	{
		return this.lecturerRepository.IsLecturerActive(lecturerSeqID);
	}
	
	public Boolean DeleteLecturer (String lecturerID)
	{
		return this.lecturerRepository.DeleteLecturer(lecturerID);
	}
	
	public Boolean IsLecturerExists (String lecturerID)
	{
		return this.lecturerRepository.IsLecturerExists(lecturerID);
	}
	
	
	public Boolean InsertNewLecturer (Lecturer l)
	{
		return this.lecturerRepository.InsertNewLecturer(l);
	}
	
	
}
