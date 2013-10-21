package com.cg.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the representative database table.
 * 
 */
@Entity
public class Representative implements Serializable {
	private static final long serialVersionUID = 1L;
	private String representative_id;
	private String password;
	private String representative_Name;

	public Representative() {
	}


	@Id
	public String getRepresentative_id() {
		return this.representative_id;
	}

	public void setRepresentative_id(String representative_id) {
		this.representative_id = representative_id;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepresentative_Name() {
		return this.representative_Name;
	}

	public void setRepresentative_Name(String representative_Name) {
		this.representative_Name = representative_Name;
	}

}