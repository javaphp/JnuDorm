package cn.jnu.dorm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.DormInfoDao;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.service.DormInfoService;

@Service
@Transactional
public class DormInfoServiceImpl implements DormInfoService {

	@Resource
	public DormInfoDao dormInfoDao;
	
	public List<DormInfo> findAll() {
		return dormInfoDao.findAll();
	}

	public void save(DormInfo model) {
		dormInfoDao.save(model);
	}

	public DormInfo findById(int id) {
		return dormInfoDao.findById(id);
	}

	public void delete(DormInfo dormInfo) {
		dormInfoDao.delete(dormInfo);
	}

	public void update(DormInfo dormInfo) {
		dormInfoDao.update(dormInfo);
	}

}
