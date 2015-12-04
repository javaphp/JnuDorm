package cn.jnu.dorm.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	
	public int id;
	public int cardId;
	public String name;
	public String major;
	public String college;
	public int grade;
	public String gender;
	public String resource;
	public String type;
	public int yearLength;
	public String campus;
	public DormInfo dormInfo;
	public Date inDate;
	public Date outDate;
	public Set<Bill> bill = new HashSet<Bill>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int studentId) {
		this.cardId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYearLength() {
		return yearLength;
	}
	public void setYearLength(int yearLength) {
		this.yearLength = yearLength;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public DormInfo getDormInfo() {
		return dormInfo;
	}
	public void setDormInfo(DormInfo dormInfo) {
		this.dormInfo = dormInfo;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	
	public Set<Bill> getBill() {
		return bill;
	}
	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}
	public Student() {
		
	}
	public Student(int cardId, String name, String major, String college,
			int grade, String gender, String resource, String type,
			int yearLength, String campus, Date inDate, Date outDate) {
		super();
		this.cardId = cardId;
		this.name = name;
		this.major = major;
		this.college = college;
		this.grade = grade;
		this.gender = gender;
		this.resource = resource;
		this.type = type;
		this.yearLength = yearLength;
		this.campus = campus;
		this.inDate = inDate;
		this.outDate = outDate;
	}
	
}
