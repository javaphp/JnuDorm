package cn.jnu.dorm.dao.impl;

import java.util.Collection;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.jnu.dorm.base.BaseDaoImpl;
import cn.jnu.dorm.dao.PrivilegeDao;
import cn.jnu.dorm.domain.Privilege;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	public List<Privilege> findByIds(Integer[] privilegeIds) {
		
		return getSession().createQuery(
				"FROM Privilege p WHERE p.id IN (:ids)")
				.setParameterList("ids", privilegeIds)
				.list();
	}

	public Collection<String> findAllUrls() {
		return getSession().createQuery(
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")
				.list();
	}

}
