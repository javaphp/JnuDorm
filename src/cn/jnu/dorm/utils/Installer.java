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
		privilegeStudent = new Privilege("ѧ���б�", "/student_list");
		session.save(privilegeStudent);
		session.save(new Privilege("����ѧ��", "/student_add"));
		session.save(new Privilege("�޸�ѧ����Ϣ", "/student_edit"));
		session.save(new Privilege("ɾ��ѧ��", "/student_delete"));
		
		session.save(new Privilege("�˵��б�", "/bill_list"));
		session.save(new Privilege("�����˵�", "/bill_add"));
		session.save(new Privilege("�޸��˵�", "/bill_edit"));
		session.save(new Privilege("ɾ���˵�", "/bill_delete"));
		
		session.save(new Privilege("��������", "/dormInfo_add"));
		session.save(new Privilege("�޸�������Ϣ", "/dormInfo_edit"));
		session.save(new Privilege("�����б�", "/dormInfo_list"));
		session.save(new Privilege("ɾ������", "/dormInfo_delete"));
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
	
}
