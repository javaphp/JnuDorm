package cn.jnu.dorm.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jnu.dorm.domain.Student;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class SpringTest {
	

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println("------->>>>>" + sessionFactory);
	}
	
}
