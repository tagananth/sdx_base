package org.servicedx.bean.model;

public interface ICommonCustomerBean extends ICommonModeBean
{
	long getCustomerId();

	void setCustomerId(long customerId);

	String getCustomerName();

	void setCustomerName(String customerName);
}
