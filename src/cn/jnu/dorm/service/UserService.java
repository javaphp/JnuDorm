package cn.jnu.dorm.service;

import java.util.List;

import cn.jnu.dorm.domain.User;

public interface UserService {

	void save(User user);

	List<User> findAll();

	User findById(int id);

	void delete(User user);

	boolean login(String userName, String password);

	User findByNameAndPassword(String userName, String password);

	boolean checkUserName(String name);

	void update(User user);

}
