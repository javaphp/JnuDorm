package cn.jnu.dorm.domain;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class DormInfo {

	public int id;
	public String name;
	public String floor;
	public String room;
	public Set<Bill> bill;
	public Set<Student> student = new HashSet<Student>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	public Set<Bill> getBill() {
		return bill;
	}
	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public DormInfo(String name, String floor, String room) {
		super();
		this.name = name;
		this.floor = floor;
		this.room = room;
	}
	public DormInfo() {
		
	}
	
}
