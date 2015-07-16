package com.whut.web.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "resource")
public class Resource extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7798616583473655500L;
	
	private int id;
	private String name;
	private String uri;
	private String method;
	private String module;
	
	private Set<Role> roles; // 多个角色

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(int id, String name, String uri, String method,
			String module, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.uri = uri;
		this.method = method;
		this.module = module;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "resources")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
