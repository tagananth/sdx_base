package org.servicedx.bean;

import org.servicedx.bean.model.Customer;
import org.springframework.security.core.Authentication;

public class CustomerFormBean extends APIStatus
{

	private static final long	serialVersionUID	= 5862342185767193951L;

	public Customer				customer			= new Customer();

	public Customer				repoCustomer;

	public void updateRepoCustomer(Authentication auth)
	{
		repoCustomer.setActive(customer.isActive());
		repoCustomer.setComments(customer.getComments());
		repoCustomer.setCustomerName(customer.getCustomerName());
		repoCustomer.modifiedUserInfo(auth);
	}
}
