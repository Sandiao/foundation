package com.whut.web.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = -7543356199170848720L;

	private String id;
	private String name;
	private String password;
	private String email;
	private String mobile;
	private boolean enabled;
	private String deadtime;
	private String lastexittime;
	private String lastlogintime;
	private String registertime;
	private String loginIP;

	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
	}

	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDeadtime() {
		return deadtime;
	}

	public void setDeadtime(String deadtime) {
		this.deadtime = deadtime;
	}

	public String getLastexittime() {
		return lastexittime;
	}

	public void setLastexittime(String lastexittime) {
		this.lastexittime = lastexittime;
	}

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getRegistertime() {
		return registertime;
	}

	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "userRole", joinColumns = { @JoinColumn(name ="userId" )},
		inverseJoinColumns = { @JoinColumn(name = "roleId") })
	public Set<Role> getRoles() {
		return roles;
	}

	@JsonProperty("roles") // @JsonProperty enable the deserialization of roles
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
