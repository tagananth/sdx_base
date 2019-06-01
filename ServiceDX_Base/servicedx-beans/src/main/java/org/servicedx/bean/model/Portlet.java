package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="portlets")
public class Portlet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2553135535079110497L;

	private String portletId;
	
	private String portletName;
	
	private Boolean status;
	
	private String type;

	@Column(name="portletid")
	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

	@Column(name="portletname")
	public String getPortletName() {
		return portletName;
	}

	public void setPortletName(String portletName) {
		this.portletName = portletName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}