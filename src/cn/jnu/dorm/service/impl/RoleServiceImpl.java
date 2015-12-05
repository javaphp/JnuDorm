package cn.jnu.dorm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.RoleDao;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;
import cn.jnu.dorm.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	public RoleDao roleDao;
	
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Deprecated
	public List<Privilege> findAllPrivilege() {
		return roleDao.findAllPrivilege();
	}

	public void delete(Role role) {
		roleDao.delete(role);
	}

	public Role findById(int id) {
		return roleDao.findById(id);
	}

	public void save(Role role) {
		roleDao.save(role);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public List<Privilege> findTopPrivilege() {
		return roleDao.findTopPrivilege();
	}

	public List<Role> findByIds(Integer[] roleIds) {
		return roleDao.findByIds(roleIds);
	}

}
