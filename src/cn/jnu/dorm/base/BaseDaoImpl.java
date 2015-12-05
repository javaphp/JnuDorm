package cn.jnu.dorm.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.jnu.dorm.service.StudentService;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	public Class clazz;
	@Resource
	public SessionFactory sessionFactory;
	
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println("clazz------>>>>" + clazz);
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(T entity) {
		if(entity != null) {
			getSession().delete(entity);
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

	public T findById(int id) {
		return (T) getSession().get(clazz, id);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public List<T> findByIds(Integer[] ids) {
		return getSession().createQuery(
				"FROM " + clazz.getSimpleName() + " clazz WHERE clazz.id IN (:ids)")
				.setParameterList("ids", ids)
				.list();
	}

	
}
