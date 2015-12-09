package cn.jnu.dorm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jnu.dorm.base.BaseDaoImpl;
import cn.jnu.dorm.dao.BillDao;
import cn.jnu.dorm.domain.Bill;
import cn.jnu.dorm.domain.DormInfo;
import cn.jnu.dorm.domain.User;

@Repository
public class BillDaoImpl extends BaseDaoImpl<Bill> implements BillDao {

	public List<DormInfo> findDormBuilding() {
		
		return getSession().createQuery(//
				"SELECT DISTINCT name FROM DormInfo")
				.list();
	}

	public List<DormInfo> findByName(String dormName) {
		return getSession().createQuery(
				"FROM DormInfo d WHERE d.name = ?")
				.setParameter(0, dormName)
				.list();
	}

	public List<Bill> findUserBills(DormInfo dormInfo) {
		return getSession().createQuery(
				"FROM Bill bill WHERE bill.dormInfo = ?")
				.setParameter(0, dormInfo)
				.list();
	}


}
