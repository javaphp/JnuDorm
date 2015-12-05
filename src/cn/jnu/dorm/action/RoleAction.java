package cn.jnu.dorm.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.Privilege;
import cn.jnu.dorm.domain.Role;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private Integer[] privilegeIds;
	
	public String setPrivilegeUI() throws Exception {
		List<Privilege> topPrivilegeList = roleService.findTopPrivilege();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		
		Role role = roleService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		if(role.getPrivileges() != null) {
			for(Privilege priv : role.getPrivileges()) {
				privilegeIds = new Integer[role.getPrivileges().size()];
				int index = 0;
				privilegeIds[index++] = priv.getId();
			}
		}
		return "setPrivilegeUI";
	}
	
	public String setPrivilege() throws Exception {
		Role role = roleService.findById(model.getId());
		List<Privilege> privileges = privilegeService.findByIds(privilegeIds);
		role.setPrivileges(new HashSet(privileges));
		roleService.update(role);
		return "toList";
	}
	
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	public String add() throws Exception {
		Role role = new Role();
		role.setName(model.getName());
		roleService.save(role);
		return "toList";
	}
	
	public String delete() throws Exception {
		Role role = roleService.findById(model.getId());
		roleService.delete(role);
		return "toList";
	}
	
	public String editUI() throws Exception {
		Role role = roleService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	public String edit() throws Exception {
		Role role = roleService.findById(model.getId());
		role.setName(model.getName());
		roleService.update(role);
		return "toList";
	}
	
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	//------------------------
	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
}
