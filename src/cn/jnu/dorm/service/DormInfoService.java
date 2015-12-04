package cn.jnu.dorm.service;

import java.util.List;

import cn.jnu.dorm.domain.DormInfo;

public interface DormInfoService {

	List<DormInfo> findAll();

	void save(DormInfo model);

	DormInfo findById(int id);

	void delete(DormInfo dormInfo);

	void update(DormInfo dormInfo);

}
