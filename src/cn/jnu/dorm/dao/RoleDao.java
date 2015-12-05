package cn.jnu.dorm.dao;

import java.util.List;

import cn.jnu.dorm.base.BaseDao;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;

public interface RoleDao extends BaseDao<Role> {

	List<Privilege> findAllPrivilege();

	List<Privilege> findTopPrivilege();

}
