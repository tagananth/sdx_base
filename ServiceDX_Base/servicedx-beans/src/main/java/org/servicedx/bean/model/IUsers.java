package org.servicedx.bean.model;

import java.time.LocalDateTime;
import java.util.List;

import org.servicedx.util.ICRUDBean;

public interface IUsers extends ICommonModeBean, ICRUDBean, IAddress, ICommunicationMedia, ICommonCustomerBean
{
	List<Roles> getRoles();

	String getUserName();

	void setUserName(String userName);

	String getEmployeeId();

	String getFirstName();

	String getLastName();

	String getPassword();

	String getProfileImageUrl();

	LocalDateTime getPwdChangeDate();

	String getRoleId();

	String getRoleName();

	String getTokenKey();

	LocalDateTime getTokenKeyExpiryDate();

	long getDepartmentId();

	String getDepartmentName();

	long getUserId();

	boolean isPwdChangeFlag();

	void setEmployeeId(String employeeId);

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setPassword(String password);

	void setProfileImageUrl(String profileImageUrl);

	void setPwdChangeDate(LocalDateTime pwdChangeDate);

	void setPwdChangeFlag(boolean pwdChangeFlag);

	void setRoleId(String roleId);

	void setRoleName(String roleName);

	void setTokenKey(String tokenKey);

	void setTokenKeyExpiryDate(LocalDateTime tokenKeyExpiryDate);

	void setUserId(long userId);

	void setDepartmentId(long DepartmentId);

	void setDepartmentName(String DepartmentName);

}