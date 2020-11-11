package com.placideh.hibernate6;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	@ManyToMany(mappedBy="laptop")
	private List<Student>stud=new ArrayList<Student>();
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public List<Student> getStud() {
		return stud;
	}
	public void setStud(List<Student>stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "LapTop [lid=" + lid + ", lname=" + lname + "]";
	}
	
	
}
