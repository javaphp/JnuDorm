package cn.jnu.dorm.domain;

import java.util.Set;

public class Privilege {
	
	public int id;
	public String name;
	public String url;
	
	public Set<Role> roles;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public Privilege() {
		
	}
	

}
