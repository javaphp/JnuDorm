package cn.jnu.dorm.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.PrivilegeDao;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeDao privilegeDao;
	
	public List<Privilege> findByIds(Integer[] privilegeIds) {
		return privilegeDao.findByIds(privilegeIds);
	}

	public Collection<String> findAllUrls() {
		return privilegeDao.findAllUrls();
	}

}
