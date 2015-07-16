package com.whut.web.entity;

public class UserQueryBean {
	
	private String id;
	private String name;
	private String email;
	
	private String minLastLoginTime;
	private String maxLastLoginTime;	
	private String minRegisterTime;
	private String maxRegisterTime;
	
	private String minDeadTime;
	private String maxDeadTime;	
	private String loginIp;
	private boolean enabled;
	
	public UserQueryBean() {
		super();
	}

	public UserQueryBean(String id, String name, String email,
			String minLastLoginTime, String maxLastLoginTime,
			String minRegisterTime, String maxRegisterTime, String minDeadTime,
			String maxDeadTime, String loginIp, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.minLastLoginTime = minLastLoginTime;
		this.maxLastLoginTime = maxLastLoginTime;
		this.minRegisterTime = minRegisterTime;
		this.maxRegisterTime = maxRegisterTime;
		this.minDeadTime = minDeadTime;
		this.maxDeadTime = maxDeadTime;
		this.loginIp = loginIp;
		this.enabled = enabled;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMinLastLoginTime() {
		return minLastLoginTime;
	}

	public void setMinLastLoginTime(String minLastLoginTime) {
		this.minLastLoginTime = minLastLoginTime;
	}

	public String getMaxLastLoginTime() {
		return maxLastLoginTime;
	}

	public void setMaxLastLoginTime(String maxLastLoginTime) {
		this.maxLastLoginTime = maxLastLoginTime;
	}

	public String getMinRegisterTime() {
		return minRegisterTime;
	}

	public void setMinRegisterTime(String minRegisterTime) {
		this.minRegisterTime = minRegisterTime;
	}

	public String getMaxRegisterTime() {
		return maxRegisterTime;
	}

	public void setMaxRegisterTime(String maxRegisterTime) {
		this.maxRegisterTime = maxRegisterTime;
	}

	public String getMinDeadTime() {
		return minDeadTime;
	}

	public void setMinDeadTime(String minDeadTime) {
		this.minDeadTime = minDeadTime;
	}

	public String getMaxDeadTime() {
		return maxDeadTime;
	}

	public void setMaxDeadTime(String maxDeadTime) {
		this.maxDeadTime = maxDeadTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		String query = "";
		if (null == id || id.equals("")) {
			query += "";
		} else {
			query += "id=" + id + "&";
		}
		
		if (null == name || name.equals("")) {
			query += "";
		} else {
			query += "name" + name + "&";
		}
		
		if (null == email || email.equals("")) {
			query += "";
		} else {
			query += "email=" + email + "&";
		}
		
		if (null == minLastLoginTime || minLastLoginTime.equals("")) {
			query += "";
		} else {
			query += "minLastLoginTime=" + minLastLoginTime + "&";
		}
		
		if (null == maxLastLoginTime || maxLastLoginTime.equals("")) {
			query += "";
		} else {
			query += "maxLastLoginTime=" + maxLastLoginTime + "&";
		}
		
		if (null == minRegisterTime || minRegisterTime.equals("")) {
			query += "";
		} else {
			query += "minRegisterTime=" + minRegisterTime + "&";
		}
		
		if (null == maxRegisterTime || maxRegisterTime.equals("")) {
			query += "";
		} else {
			query += "maxRegisterTime=" + maxRegisterTime + "&";
		}
		
		if (null == minDeadTime || minDeadTime.equals("")) {
			query += "";
		} else {
			query += "minDeadTime=" + minDeadTime + "&";
		}
		
		if (null == maxDeadTime || maxDeadTime.equals("")) {
			query += "";
		} else {
			query += "maxDeadTime=" + maxDeadTime + "&";
		}
		
		if (null == loginIp || loginIp.equals("")) {
			query += "";
		} else {
			query += "loginIp=" + loginIp + "&";
		}
	
		query += "enabled=" + enabled;
		
		return  query;
	}
	
}
