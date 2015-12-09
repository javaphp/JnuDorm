package cn.jnu.dorm.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;
import cn.jnu.dorm.domain.User;
import cn.jnu.dorm.service.RoleService;
import cn.jnu.dorm.service.UserService;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	
	public String index() throws Exception {
		return "index";
	}
	
	public String error() throws Exception {
		return "error";
	}
	
	public String left() throws Exception {
		List<Privilege> privilegeList = new ArrayList<Privilege>();
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			return "loginUI";
		} else {
			privilegeList = roleService.findTopPrivilege();
			
			/*
			List<Role> roleList = new ArrayList<Role>();
			roleList.addAll(user.getRoles());
			for(Role role : roleList) {
				for(Privilege priv : role.getPrivileges()) {
					if(priv.getUrl() != null) {
						privilegeList.add(priv);
					}
				}
			}*/
		}
		ActionContext.getContext().put("privilegeList", privilegeList);
		return "left";
	}
	
}
