package cn.jnu.dorm.service;

import java.util.List;

import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;

public interface RoleService {

	List<Role> findAll();

	List<Privilege> findAllPrivilege();

	void save(Role role);

	Role findById(int id);

	void delete(Role role);

	void update(Role role);

	List<Privilege> findTopPrivilege();

	List<Role> findByIds(Integer[] roleIds);

}
