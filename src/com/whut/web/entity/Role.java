package com.whut.web.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7980619165109082142L;
	
	private int id;
	private String name; // 角色名称
	private String description;// 角色标识
	
	private Set<User> users;
	private Set<Resource> resources;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, String description,
			Set<User> users, Set<Resource> resources) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
		this.resources = resources;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore // @JsonIgnore disable serialization of users
	@ManyToMany(mappedBy = "roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "roleResource", joinColumns = { @JoinColumn(name ="roleId" )},
		inverseJoinColumns = { @JoinColumn(name = "resourceId") })
	public Set<Resource> getResources() {
		return resources;
	}

	@JsonProperty("resources")
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
}
