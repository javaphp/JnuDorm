package cn.jnu.dorm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.StudentDao;
import cn.jnu.dorm.domain.Student;
import cn.jnu.dorm.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	public Student findById(int id) {
		return studentDao.findById(id);
	}

	public void update(Student student) {
		studentDao.update(student);
	}

	public void save(Student model) {
		studentDao.save(model);
	}

	public void delete(Student student) {
		studentDao.delete(student);
	}

	public Student findByCardIdAndPassword(int cardId, String passwordHex) {
		return studentDao.findByCardIdAndPassword(cardId, passwordHex);
	}

	public List<Student> findList(int pageNum, int pageSize) {
		int firstResult = (pageNum - 1) * pageSize + 1;
		int maxResult = pageSize;
		return studentDao.findList(pageNum, firstResult, maxResult);
	}

	

}
