package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommunicationMedia extends Address implements ICommunicationMedia
{
	private static final long	serialVersionUID	= -2389161513595163608L;

	protected String			emailId				= "";

	protected String			emailId1			= "";

	protected String			mobileNo			= "";

	protected String			mobileNo1			= "";

	protected String			otp					= "";

	public CommunicationMedia()
	{
		super();
	}

	@Override
	@Column(name = "emailid")
	public String getEmailId()
	{
		return emailId;
	}

	@Override
	@Column(name = "emailid1")
	public String getEmailId1()
	{
		return emailId1;
	}

	@Override
	@Column(name = "mobileno")
	public String getMobileNo()
	{
		return mobileNo;
	}

	@Override
	@Column(name = "mobileno1")
	public String getMobileNo1()
	{
		return mobileNo1;
	}

	@Override
	@Column(name = "otp")
	public String getOtp()
	{
		return otp;
	}

	@Override
	public void setEmailId(String emailId)
	{
		this.emailId = (emailId == null ? "" : emailId.toLowerCase());
	}

	@Override
	public void setEmailId1(String emailId1)
	{
		this.emailId1 = (emailId1 == null ? "" : emailId1.toLowerCase());
	}

	@Override
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	@Override
	public void setMobileNo1(String mobileNo1)
	{
		this.mobileNo1 = mobileNo1;
	}

	@Override
	public void setOtp(String otp)
	{
		this.otp = otp;
	}
}