package cn.jnu.dorm.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import cn.jnu.dorm.domain.Student;
import cn.jnu.dorm.service.BillService;
import cn.jnu.dorm.service.DormInfoService;
import cn.jnu.dorm.service.StudentService;
import cn.jnu.dorm.service.UserService;
import cn.jnu.dorm.service.impl.BillServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	protected T model;
	
	public BaseAction() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			this.model = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Resource
	protected StudentService studentService;
	@Resource
	protected DormInfoService dormInfoService;
	@Resource
	protected BillService billService;
	@Resource
	protected UserService userService;
	
	public T getModel() {
		return model;
	}
	
}
