package org.servicedx.bean;

import org.servicedx.security.resource.IPath.EFormAction;

public class PasswordFormBean extends APIStatus
{
	private static final long	serialVersionUID	= 8292008040523676703L;

	public long					userId;

	public String				oldPassword;

	public String				newPassword;

	public EFormAction			eFormAction			= EFormAction.ChangePassword;
	
	public String tokenUrl;
	
	public OTPFormBean otp;

}
