package cn.jnu.dorm.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.security.krb5.internal.crypto.d;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.domain.Role;
import cn.jnu.dorm.domain.Student;
import cn.jnu.dorm.utils.Pagination;

@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student>{
	
	private int cardNum;
	private String myPassword;
	private int dormId;
	
	public String add() {
		String passwordHex = DigestUtils.md5Hex(model.getCardId() + "");
		model.setPassword(passwordHex); //学生的默认密码为cardId
		
		Role role = roleService.findByName("学生");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		model.setRoles(roles);   //学生的默认角色为学生
		
		studentService.save(model);
		return "toList";
	}
	
	public String addUI() {
		List<DormInfo> buildingList = billService.findDormBuilding();
		DormInfo dorm;
		List<DormInfo> dormInfoList = new ArrayList<DormInfo>();
		for (int i=0;i<buildingList.size();i++) {
			dorm = new DormInfo();
			dorm.setName(buildingList.get(i) + "");
			dormInfoList.add(dorm);
		}
		ActionContext.getContext().put("dormInfoList", dormInfoList);
		return "saveUI";
	}
	
	public String delete() {
		Student student = studentService.findById(model.getId());
		studentService.delete(student);
		return "toList";
	}
	
	public String edit() {
		Student student = studentService.findById(model.getId());
		
		student.setName(model.getName());
		student.setCardId(model.getCardId());
		student.setMajor(model.getMajor());
		student.setCollege(model.getCollege());
		student.setGrade(model.getGrade());
		student.setGender(model.getGender());
		student.setResource(model.getResource());
		student.setType(model.getType());
		student.setYearLength(model.getYearLength());
		student.setCampus(model.getCampus());
		student.setInDate(model.getInDate());
		student.setOutDate(model.getOutDate());
		
		System.out.println("dormId>>>>>" + dormId); // TODO
		DormInfo dormInfo = dormInfoService.findById(dormId);
		
		student.setDormInfo(dormInfo);
		
		studentService.update(student);
		return "toList";
	}
	public String editUI() throws Exception{
		List<DormInfo> buildingList = billService.findDormBuilding();
		DormInfo dorm;
		List<DormInfo> dormInfoList = new ArrayList<DormInfo>();
		for (int i=0;i<buildingList.size();i++) {
			dorm = new DormInfo();
			dorm.setName(buildingList.get(i) + "");
			dormInfoList.add(dorm);
		}
		ActionContext.getContext().put("dormInfoList", dormInfoList);
		Student student = studentService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(student);
		return "saveUI";
	}
	public String list() throws Exception{
		List<Student> studentList = studentService.findAll();
		int recordCount = studentList.size();
		List<Student> recordList = studentService.findList(pageNum, pageSize);
		Pagination pageBean = new Pagination(pageNum, pageSize, recordCount, recordList);
		ActionContext.getContext().getValueStack().push(pageBean);
		//ActionContext.getContext().put("studentList", studentList);
		return "list";
	}
	public String loginUI() throws Exception {
		System.out.println("myPassword>>>>>>>>" + myPassword);
		return "loginUI";
	}
	public String login() throws Exception {
		String passwordHex = DigestUtils.md5Hex(myPassword);
		System.out.println("myPassword>>>>>>>>" + myPassword);
		Student student = studentService.findByCardIdAndPassword(cardNum, passwordHex);
		if(student != null) {
			ActionContext.getContext().getSession().put("student", student);
			return "toBill";
		}
		return "toLoginUI";
	}

	//---------------------------------------

	public String getMyPassword() {
		return myPassword;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}

	public int getDormId() {
		return dormId;
	}

	public void setDormId(int dormId) {
		this.dormId = dormId;
	}
	
}
