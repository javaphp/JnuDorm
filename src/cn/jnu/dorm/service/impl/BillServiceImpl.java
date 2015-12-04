package cn.jnu.dorm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.dao.BillDao;
import cn.jnu.dorm.domain.Bill;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService{

	@Resource
	public BillDao billDao;
	
	public void delete(Bill model) {
		billDao.delete(model);
	}

	public List<Bill> findAll() {
		return billDao.findAll();
	}

	public Bill findById(int id) {
		return billDao.findById(id);
	}

	public void save(Bill model) {
		billDao.save(model);
	}

	public void update(Bill bill) {
		billDao.update(bill);
	}

	public List<DormInfo> findDormBuilding() {
		return billDao.findDormBuilding();
	}

	public List<DormInfo> findByName(String dormName) {
		return billDao.findByName(dormName);
	}

}
