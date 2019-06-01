package org.servicedx.bean.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.servicedx.security.resource.IPath.EAuth;
import org.springframework.security.core.Authentication;

@MappedSuperclass
public abstract class CommonBeanFields implements ICommonBeanFields
{
	private static final long	serialVersionUID	= -7237295401543075613L;
	protected long				createdBy;
	protected String			createdByName;
	protected LocalDateTime		createdDate;
	protected long				modifiedBy;
	protected String			modifiedByName;
	protected LocalDateTime		modifiedDate;
	protected boolean			status				= true;

	protected abstract void customerInfo(Authentication auth);

	public void createdUserCustomerInfo(Authentication auth)
	{
		this.createdBy = EAuth.User.getUserId(auth);
		this.createdByName = EAuth.User.getFullName(auth);
		this.createdDate = LocalDateTime.now();
		customerInfo(auth);
		modifiedUserInfo(auth);
	}

	public void modifiedUserInfo(Authentication auth)
	{
		this.modifiedBy = EAuth.User.getUserId(auth);
		this.modifiedByName = EAuth.User.getFullName(auth);
		this.modifiedDate = LocalDateTime.now();
	}

	public CommonBeanFields()
	{
		super();
	}

	public CommonBeanFields(long createdBy, String createdByName, long modifiedBy, String modifiedByName)
	{
		super();
		this.createdBy = createdBy;
		this.createdByName = createdByName;
		this.modifiedBy = modifiedBy;
		this.modifiedByName = modifiedByName;
	}

	@Column(name = "createdby")
	public long getCreatedBy()
	{
		return createdBy;
	}

	@Column(name = "createdbyname")
	public String getCreatedByName()
	{
		return createdByName;
	}

	@Column(name = "createddate")
	public LocalDateTime getCreatedDate()
	{
		return createdDate;
	}

	@Column(name = "modifiedby")
	public long getModifiedBy()
	{
		return modifiedBy;
	}

	@Column(name = "modifiedbyname")
	public String getModifiedByName()
	{
		return modifiedByName;
	}

	@Column(name = "modifieddate")
	public LocalDateTime getModifiedDate()
	{
		return modifiedDate;
	}

	@Column(name = "status")
	public boolean isStatus()
	{
		return status;
	}

	public void setCreatedBy(long createdBy)
	{
		this.createdBy = createdBy;
	}

	public void setCreatedByName(String createdByName)
	{
		this.createdByName = createdByName;
	}

	public void setCreatedDate(LocalDateTime createdDate)
	{
		this.createdDate = createdDate;
	}

	public void setModifiedBy(long modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedByName(String modifiedByName)
	{
		this.modifiedByName = modifiedByName;
	}

	public void setModifiedDate(LocalDateTime modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

	public void setStatus(Boolean status)
	{
		this.status = status;
	}

}
