package cn.jnu.dorm.dao;

import java.util.List;

import cn.jnu.dorm.base.BaseDao;
import cn.jnu.dorm.domain.Bill;
import cn.jnu.dorm.domain.DormInfo;

public interface BillDao extends BaseDao<Bill> {

	List<DormInfo> findDormBuilding();

	List<DormInfo> findByName(String dormName);

}
