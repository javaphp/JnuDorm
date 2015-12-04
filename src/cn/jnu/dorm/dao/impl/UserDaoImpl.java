package cn.jnu.dorm.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jnu.dorm.base.BaseDaoImpl;
import cn.jnu.dorm.dao.UserDao;
import cn.jnu.dorm.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User findByNameAndPassword(String userName, String password) {
		return (User) getSession().createQuery(
				"FROM User u WHERE u.name = ? AND password = ?")
				.setParameter(0, userName)
				.setParameter(1, password)
				.uniqueResult();
	}

	public User findByName(String name) {
		return (User) getSession().createQuery(
				"FROM User u WHERE u.name = ?")
				.setParameter(0, name)
				.uniqueResult();
	}

}
