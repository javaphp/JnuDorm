package cn.jnu.dorm.utils;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;

import com.opensymphony.xwork2.ActionContext;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install() {
		Privilege privilegeStudent,privilegeBill, privilegeDorm;
		Session session = sessionFactory.getCurrentSession();
		privilegeStudent = new Privilege("学生列表", "/student_list");
		session.save(privilegeStudent);
		session.save(new Privilege("增加学生", "/student_add"));
		session.save(new Privilege("修改学生信息", "/student_edit"));
		session.save(new Privilege("删除学生", "/student_delete"));
		
		session.save(new Privilege("账单列表", "/bill_list"));
		session.save(new Privilege("增加账单", "/bill_add"));
		session.save(new Privilege("修改账单", "/bill_edit"));
		session.save(new Privilege("删除账单", "/bill_delete"));
		
		session.save(new Privilege("增加宿舍", "/dormInfo_add"));
		session.save(new Privilege("修改宿舍信息", "/dormInfo_edit"));
		session.save(new Privilege("宿舍列表", "/dormInfo_list"));
		session.save(new Privilege("删除宿舍", "/dormInfo_delete"));
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
	
}
