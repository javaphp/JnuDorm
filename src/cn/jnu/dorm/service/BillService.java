package cn.jnu.dorm.service;

import java.util.List;

import cn.jnu.dorm.domain.Bill;
import cn.jnu.dorm.domain.DormInfo;

public interface BillService {

	void save(Bill model);

	Bill findById(int id);

	void delete(Bill model);

	void update(Bill bill);

	List<Bill> findAll();

	List<DormInfo> findDormBuilding();

	List<DormInfo> findByName(String dormName);

}
