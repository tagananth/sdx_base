package org.servicedx.bean.model;

public interface ICommonModeBean extends ICommonBeanFields
{
	String getComments();

	boolean isActive();

	void setActive(boolean active);

	void setComments(String comments);
}