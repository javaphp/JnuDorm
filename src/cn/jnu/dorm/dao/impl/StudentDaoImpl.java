package cn.jnu.dorm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.jnu.dorm.base.BaseDaoImpl;
import cn.jnu.dorm.dao.StudentDao;
import cn.jnu.dorm.domain.Student;

@Repository
class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	public Student findByCardIdAndPassword(int cardId, String passwordHex) {
		return (Student) getSession().createQuery(
				"FROM Student s WHERE s.cardId = ? AND s.password = ?")
				.setParameter(0, cardId)
				.setParameter(1, passwordHex)
				.uniqueResult();
	}

}
