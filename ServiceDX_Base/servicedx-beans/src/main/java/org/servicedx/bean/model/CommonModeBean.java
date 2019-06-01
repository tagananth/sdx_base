package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonModeBean extends CommonBeanFields implements ICommonModeBean
{

	private static final long	serialVersionUID	= -9011290790620223523L;
	protected boolean			active;
	protected String			comments;

	@Column(name = "comments")
	public String getComments()
	{
		return comments;
	}

	@Override
	@Column(name = "active")
	public boolean isActive()
	{
		return active;
	}

	@Override
	public void setActive(boolean active)
	{
		this.active = active;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

}
