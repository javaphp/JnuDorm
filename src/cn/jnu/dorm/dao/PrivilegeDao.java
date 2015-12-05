package cn.jnu.dorm.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.jnu.dorm.base.BaseDao;
import cn.jnu.dorm.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {

	List<Privilege> findByIds(Integer[] privilegeIds);

	Collection<String> findAllUrls();

}
