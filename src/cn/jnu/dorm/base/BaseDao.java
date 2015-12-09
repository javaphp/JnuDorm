package cn.jnu.dorm.base;

import java.util.List;

public interface BaseDao<T> {
	
	List<T> findAll();
	
	T findById(int id);
	
	void save(T entity);
	
	void delete(T entity);
	
	void update(T entity);
	
	List<T> findByIds(Integer[] ids); 
	
	List<T> findList(int pageNum, int firstResult, int maxResult);
}
