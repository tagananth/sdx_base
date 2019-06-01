package org.servicedx.bean;

import org.servicedx.bean.model.Users;


public class OTPFormBean extends APIStatus
{
	private static final long	serialVersionUID	= 2473153333582197660L;

	public String				id;

	public String				otp;

	public Users				user;

	public long					customerId;
	
	public String				tokenUrl;
}
