package cn.jnu.dorm.dao;

import cn.jnu.dorm.base.BaseDao;
import cn.jnu.dorm.domain.User;

public interface UserDao extends BaseDao<User> {

	User findByNameAndPassword(String userName, String password);

	User findByName(String name);

}
