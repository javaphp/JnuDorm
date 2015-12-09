package cn.jnu.dorm.action;

import java.security.MessageDigest;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.jnu.dorm.base.BaseAction;
import cn.jnu.dorm.domain.Role;
import cn.jnu.dorm.domain.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	public String userName;
	public String myPassword;
	public Integer[] roleIds;

	public String addUI() throws Exception {
		return "saveUI";
	}
	
	public String add() throws Exception {
		return "toList";
	}
	
	public String delete() throws Exception {
		User user = userService.findById(model.getId());
		userService.delete(user);
		return "toList";
	}
	
	public String editUI() throws Exception {
		return "saveUI";
	}
	public String edit() throws Exception {
		return "toList";
	}
	
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	public String registerUI() throws Exception {
		return "registerUI";
	}
	public String register() throws Exception {
		User user = new User();
		user.setName(model.getName());
		if(userService.checkUserName(model.getName())) {
			this.addFieldError("name", "用户名已存在");
			return "registerUI";
		}
		user.setEmail(model.getEmail());
		System.out.println("name-------" + model.getName());
		String md5Password = DigestUtils.md5Hex(model.getPassword());
		user.setPassword(md5Password);
		
		userService.save(user);
		return "toList";
	}
	
	public String loginUI() throws Exception {
		return "loginUI";
	}
	
	public String login() throws Exception {
		String passwordHex = DigestUtils.md5Hex(myPassword);
		if(userService.login(userName, passwordHex)) {
			User user = userService.findByNameAndPassword(userName, passwordHex);
			ActionContext.getContext().getSession().put("user", user);
			return "index";
		}else {
			return "toLoginUI";
		}
	}
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}
	
	public String setRoleUI() throws Exception {
		User user = userService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "setRoleUI";
	}
	
	public String setRole() throws Exception {
		User user = userService.findById(model.getId());
		
		List<Role> roleList = roleService.findByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		userService.update(user);
		return "toList";
	}
	
	public String checkUserName() throws Exception {
		return "toList";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	
}
