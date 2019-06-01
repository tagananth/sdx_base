package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.servicedx.security.resource.IPath.EAuth;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;

@MappedSuperclass
public abstract class CommonCustomerBean extends CommonModeBean implements ICommonCustomerBean
{

	private static final long	serialVersionUID	= -8981034590621948815L;
	protected long				customerId;
	protected String			customerName;
	protected Customer			customer			= new Customer();

	@Override
	@Column(name = "customername")
	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	@Override
	@Column(name = "customerid")
	public long getCustomerId()
	{
		return customerId;
	}

	@Override
	public void setCustomerId(long customerId)
	{
		this.customerId = customerId;
	}

	@Transient
	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public void customerInfo(Authentication auth)
	{
		this.customerId = EAuth.User.getCustomerId(auth);
		this.customerName = EAuth.User.getCustomerName(auth);
		this.customer.setCustomerId(EAuth.User.getCustomerId(auth));
		this.customer.setCustomerName(EAuth.User.getCustomerName(auth));
	}

}
