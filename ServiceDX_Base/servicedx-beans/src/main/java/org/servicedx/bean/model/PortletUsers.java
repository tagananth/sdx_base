package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "portletusers")
public class PortletUsers implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7618569867896891656L;

	private String id;
	
	private  String portletName;
	
	private String type;
	
	private int displayOrder;
	
	private String model;
	
	private Boolean status;
	
	private String userId;
	
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="displayorder")
	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Column(name="model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name="status")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name="userid")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Transient
	public String getPortletName() {
		return portletName;
	}

	@Transient
	public void setPortletName(String portletName) {
		this.portletName = portletName;
	}

	@Transient
	public String getType() {
		return type;
	}

	@Transient
	public void setType(String type) {
		this.type = type;
	}
	
	
}
