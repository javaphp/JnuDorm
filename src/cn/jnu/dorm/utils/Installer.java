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
		Privilege top, privilegeStudent,privilegeBill, privilegeDorm;
		Session session = sessionFactory.getCurrentSession();
		top = new Privilege("系统管理", null, null);
		session.save(top);
		privilegeStudent = new Privilege("学生管理", "/student_list", top);
		session.save(privilegeStudent);
		session.save(new Privilege("学生列表", "/student_list", privilegeStudent));
		session.save(new Privilege("增加学生", "/student_add", privilegeStudent));
		session.save(new Privilege("修改学生信息", "/student_edit", privilegeStudent));
		session.save(new Privilege("删除学生", "/student_delete", privilegeStudent));
		
		privilegeBill = new Privilege("账单管理", "/bill_list", top);
		session.save(privilegeBill);
		session.save(new Privilege("账单列表", "/bill_list", privilegeBill));
		session.save(new Privilege("增加账单", "/bill_add", privilegeBill));
		session.save(new Privilege("修改账单", "/bill_edit", privilegeBill));
		session.save(new Privilege("删除账单", "/bill_delete", privilegeBill));

		privilegeDorm = new Privilege("宿舍管理", "/dormInfo_list", top);
		session.save(privilegeDorm);
		session.save(new Privilege("宿舍列表", "/dormInfo_list", privilegeDorm));
		session.save(new Privilege("增加宿舍", "/dormInfo_add", privilegeDorm));
		session.save(new Privilege("修改宿舍信息", "/dormInfo_edit", privilegeDorm));
		session.save(new Privilege("删除宿舍", "/dormInfo_delete", privilegeDorm));
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
	
}
