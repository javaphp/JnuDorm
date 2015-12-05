package cn.jnu.dorm.utils;

import java.util.Collection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.service.PrivilegeService;

public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		Collection<String> allPrivilegeUrls = privilegeService.findAllUrls();
		sce.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
	}

}
