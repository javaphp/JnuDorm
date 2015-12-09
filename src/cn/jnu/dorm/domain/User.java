package cn.jnu.dorm.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;


public class User {
	
	public int id;
	public String name;
	public String email;
	public String password;
	
	public Set<Role> roles;  //角色，用户与角色是多对多

	public boolean hasPrivilegeByUrl(String url) {
		//去掉后面的参数
		int pos = url.indexOf("?");
		if(pos > -1) {
			url = url.substring(0, pos);
		}
		//去掉UI后缀
		if(url.endsWith("UI")){
			url = url.substring(0, url.length() -2);
		}
		
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext()
		.getApplication().get("allPrivilegeUrls");
		if(!allPrivilegeUrls.contains(url)) {
			return true;
		} else {
			for(Role role:roles) {
				for(Privilege priv : role.getPrivileges()) {
					if(url.equals(priv.getUrl())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean hasPrivilegeByName(String name) {
		List<Role> roleList = new ArrayList(this.getRoles());
		for(Role role : roleList) {
			for(Privilege priv : role.getPrivileges()) {
				if(name.equals(priv.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
