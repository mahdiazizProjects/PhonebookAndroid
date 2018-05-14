package com.example.phonebook;
public class phoneclass {
	
	private long id;
	private String Name;
	private String Lname;
	private String Im;
	private long phonenumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getIm() {
		return Im;
	}
	public void setIm(String im) {
		Im = im;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return Name +" "+ Lname+"\n"+Long.toString(phonenumber);
	}

}
