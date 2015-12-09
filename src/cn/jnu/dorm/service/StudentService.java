package cn.jnu.dorm.service;

import java.util.List;

import cn.jnu.dorm.domain.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(int id);

	void update(Student student);

	void save(Student model);

	void delete(Student student);

	Student findByCardIdAndPassword(int cardId, String passwordHex);

	List<Student> findList(int pageNum, int pageSize);

}
