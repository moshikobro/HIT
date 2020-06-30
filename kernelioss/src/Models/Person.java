package Models;

import java.util.Date;

public class Person {
	
	
   private	String firstName;
   private String lastName;
   private String ID;
   private String address;
   private String PhoneNumber;
   private Date birthDate;
   
	public Person(String firstName,String lastName,String ID,String address,String PhoneNumber,Date birthDate) {
		this.firstName =firstName;
		this.lastName=lastName;
		this.address=address;
		this.PhoneNumber=PhoneNumber;
		this.birthDate=birthDate;
	}
	
	public Person()
	{
		this.firstName ="";
		this.lastName="";
		this.address="";
		this.PhoneNumber="";
		this.birthDate=new Date();
	}
	
	public String GetfirstName()
	{
		return this.firstName;
	}
	public String GetLastName()
	{
		return this.lastName;
	}
	public String GetID()
	{
		return this.ID;
	}
	public String GetAddress()
	{
		return this.address;
	}
	public String GetPhoneNumber()
	{
		return this.PhoneNumber;
	}
	public Date GetbirthDate()
	{
		return this.birthDate;
	}

}
