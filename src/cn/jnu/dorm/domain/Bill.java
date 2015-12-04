package cn.jnu.dorm.domain;

import java.util.Set;

public class Bill {

	public int id;
	public String yearMonth;
	public Set<Student> student;
	public DormInfo dormInfo;
	public double shouldPay;
	public double alreadyPay;
	public double water;
	public double electricity;
	public double waterPrice;
	public double electricityPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public DormInfo getDormInfo() {
		return dormInfo;
	}
	public void setDormInfo(DormInfo dormInfo) {
		this.dormInfo = dormInfo;
	}
	public double getShouldPay() {
		return shouldPay;
	}
	public void setShouldPay(double shouldPay) {
		this.shouldPay = shouldPay;
	}
	public double getAlreadyPay() {
		return alreadyPay;
	}

	public void setAlreadyPay(double alreadyPay) {
		this.alreadyPay = alreadyPay;
	}
	public double getWater() {
		return water;
	}
	public void setWater(double water) {
		this.water = water;
	}
	public double getElectricity() {
		return electricity;
	}

	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}
	public double getWaterPrice() {
		return waterPrice;
	}
	public void setWaterPrice(double waterPrice) {
		this.waterPrice = waterPrice;
	}
	public double getElectricityPrice() {
		return electricityPrice;
	}
	public void setElectricityPrice(double electricityPrice) {
		this.electricityPrice = electricityPrice;
	}
	public Bill() {
		
	}
	
}
