package cn.jnu.dorm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jnu.dorm.base.BaseDaoImpl;
import cn.jnu.dorm.dao.RoleDao;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Deprecated
	public List<Privilege> findAllPrivilege() {
		return getSession().createQuery(
				"FROM Privilege p")
				.list();
	}

	public List<Privilege> findTopPrivilege() {
		return getSession().createQuery(
				"FROM Privilege p WHERE p.parent IS NULL")
				.list();
	}

	public Role findByName(String name) {
		return (Role) getSession().createQuery(
				"FROM Role r WHERE r.name = ?")
				.setParameter(0, name)
				.uniqueResult();
	}

}
