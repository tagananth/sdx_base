package org.servicedx.bean;

import org.servicedx.bean.model.Users;
import org.servicedx.security.resource.IPath.EEntity;
import org.servicedx.security.resource.IPath.EMedia;
import org.servicedx.util.CommonValidator;
import org.springframework.security.core.Authentication;

public class UserFormBean extends APIStatus
{
	private static final long	serialVersionUID	= 1452795795821759203L;

	public Users				repoUser;
	public String				tokenURL;
	public Users				user;
	public String				searchParam;
	public String				country;
	public String				state;
	public String				media				= EMedia.Email.name();
	public String				entity				= EEntity.User.name();
	public String				authToken;
	public String 				roleName;
	
	public boolean whetherPrimaryMediaUpdated()
	{
		if (repoUser != null && user != null)
			return CommonValidator.isNotEqual(repoUser.getEmailId(), user.getEmailId()) || CommonValidator.isNotEqual(repoUser.getMobileNo(), user.getMobileNo());
		return false;
	}

	public void updateRepoUser(Authentication auth)
	{
		repoUser.setActive(user.isActive());
		repoUser.setAddressLine1(user.getAddressLine1());
		repoUser.setAddressLine2(user.getAddressLine2());
		repoUser.setAddressLine3(user.getAddressLine3());
		repoUser.setCity(user.getCity());
		repoUser.setComments(user.getComments());
		repoUser.setCountry(user.getCountry());
		repoUser.setCountryName(user.getCountryName());
		repoUser.setCustomerId(user.getCustomerId());
		repoUser.setCustomerName(user.getCustomerName());
		repoUser.setEmailId(user.getEmailId());
		repoUser.setEmailId1(user.getEmailId1());
		repoUser.setEmployeeId(user.getEmployeeId());
		repoUser.setFirstName(user.getFirstName());
		repoUser.setLastName(user.getLastName());
		repoUser.setMobileNo(user.getMobileNo());
		repoUser.setMobileNo1(user.getMobileNo1());
		repoUser.setProfileImageUrl(user.getProfileImageUrl());
		repoUser.setRoleId(user.getRoleId());
		repoUser.setRoleName(user.getRoleName());
		repoUser.setState(user.getState());
		repoUser.setStateName(user.getStateName());
		repoUser.setZipCode(user.getZipCode());
		repoUser.setDepartmentId(user.getDepartmentId());
		repoUser.setDepartmentName(user.getDepartmentName());
		repoUser.modifiedUserInfo(auth);
	}

}
