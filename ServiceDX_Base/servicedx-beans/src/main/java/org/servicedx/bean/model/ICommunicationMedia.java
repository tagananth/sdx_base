package org.servicedx.bean.model;

import java.io.Serializable;

public interface ICommunicationMedia extends Serializable
{
	String getEmailId();

	String getEmailId1();

	String getMobileNo();

	String getMobileNo1();

	String getOtp();

	void setEmailId(String emailId);

	void setEmailId1(String emailId1);

	void setMobileNo(String mobileNo);

	void setMobileNo1(String mobileNo1);

	void setOtp(String otp);
}