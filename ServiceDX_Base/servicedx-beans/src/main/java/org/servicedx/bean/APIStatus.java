package org.servicedx.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class APIStatus implements Serializable
{
	private static final long serialVersionUID = 7838070576020990903L;

	public APIStatus()
	{
		super();
	}

	public String messageCode;
	
	@JsonIgnore
	public APIStatus getStatusBean() {
		return this;
	}
	
	@JsonIgnore
	public APIStatus getStatusBeanWithMessage(String messageCode) {
		this.messageCode = messageCode;
		return getStatusBean();
	}

}