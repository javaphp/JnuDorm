package cn.jnu.dorm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.UserDao;
import cn.jnu.dorm.domain.User;
import cn.jnu.dorm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

	public boolean login(String userName, String password) {
		User user = this.findByNameAndPassword(userName, password);
		if(user != null) {
			return true;
		}
		return false;
	}

	public User findByNameAndPassword(String userName, String password) {
		return userDao.findByNameAndPassword(userName, password);
	}

	public boolean checkUserName(String name) {
		User user = userDao.findByName(name);
		if(user != null) {
			return true;
		}
		return false;
	}

	public void update(User user) {
		userDao.update(user);
	}

}
