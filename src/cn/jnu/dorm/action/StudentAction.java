package cn.jnu.dorm.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.Student;

@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student>{
	
	public String add() {
		studentService.save(model);
		return "toList";
	}
	
	public String addUI() {
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
		
		studentService.update(student);
		return "toList";
	}
	public String editUI() {
		Student student = studentService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(student);
		return "saveUI";
	}
	public String list() {
		List<Student> studentList = studentService.findAll();
		ActionContext.getContext().put("studentList", studentList);
		return "list";
	}

}
