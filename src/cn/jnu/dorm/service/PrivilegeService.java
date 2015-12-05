package cn.jnu.dorm.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.jnu.dorm.domain.Privilege;

public interface PrivilegeService {

	List<Privilege> findByIds(Integer[] privilegeIds);

	Collection<String> findAllUrls();

}
