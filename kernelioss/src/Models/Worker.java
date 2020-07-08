package Models;

import java.util.Date;

public class Worker implements Person{
	
	
   private	String firstName;
   private String lastName;
   private String ID;
   private String address;
   private String PhoneNumber;
   private Date birthDate;
   
	public Worker(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate) {
		this.ID=ID;
		this.firstName =firstName;
		this.lastName=lastName;
		this.address=address;
		this.PhoneNumber=PhoneNumber;
		this.birthDate=birthDate;
	}
	
	public Worker()
	{
		this.firstName ="";
		this.lastName="";
		this.address="";
		this.PhoneNumber="";
		this.birthDate=new Date();
	}
	@Override
	public String GetfirstName()
	{
		return this.firstName;
	}
	@Override
	public String GetLastName()
	{
		return this.lastName;
	}
	@Override
	public String GetID()
	{
		return this.ID;
	}
	@Override
	public String GetAddress()
	{
		return this.address;
	}
	@Override
	public String GetPhoneNumber()
	{
		return this.PhoneNumber;
	}
	@Override
	public Date GetbirthDate()
	{
		return this.birthDate;
	}

}
