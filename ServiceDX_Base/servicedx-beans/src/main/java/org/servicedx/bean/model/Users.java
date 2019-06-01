package org.servicedx.bean.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.servicedx.security.resource.IPath.ERole;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Entity
@Table(name = "users")
public class Users extends CommunicationMedia implements IUsers
{
	private static final long	serialVersionUID	= -8117066273433451132L;

	protected String			employeeId;
	protected String			userName;
	protected String			firstName;
	protected String			lastName;
	protected String			password;
	protected String			profileImageUrl;
	protected LocalDateTime		pwdChangeDate;
	protected boolean			pwdChangeFlag		= false;
	protected String			roleId				= ERole.User.name();
	protected String			roleName			= ERole.User.name();
	protected String			tokenKey;
	protected LocalDateTime		tokenKeyExpiryDate;
	protected long				userId;
	protected long				departmentId;
	protected String			departmentName;

	public Users()
	{
		super();
	}

	public Users(long userId, String firstName, String lastName, String emailId, String emailId1, String mobileNo, String mobileNo1)
	{
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.emailId1 = emailId1;
		this.mobileNo = mobileNo;
		this.mobileNo1 = mobileNo1;
	}

	public Users(String employeeId, String userName, String firstName, String lastName, String password, String profileImageUrl, LocalDateTime pwdChangeDate, boolean pwdChangeFlag, String roleId,
			String roleName, String tokenKey, LocalDateTime tokenKeyExpiryDate, long userId,long departmentId,String departmentName)
	{
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.profileImageUrl = profileImageUrl;
		this.pwdChangeDate = pwdChangeDate;
		this.pwdChangeFlag = pwdChangeFlag;
		this.roleId = roleId;
		this.roleName = roleName;
		this.tokenKey = tokenKey;
		this.tokenKeyExpiryDate = tokenKeyExpiryDate;
		this.userId = userId;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Users(String employeeId)
	{
		super();
		this.employeeId = employeeId;
	}

	@Override
	@Transient
	public List<Roles> getRoles()
	{

		List<Roles> roleList = new ArrayList<Roles>();
		roleList.add(new Roles(roleId));
		return roleList;
	}

	@Override
	@Column(name = "username")
	public String getUserName()
	{
		return userName;
	}

	@Override
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Override
	@Column(name = "employeeid")
	public String getEmployeeId()
	{
		return employeeId;
	}

	@Override
	@Column(name = "firstname")
	public String getFirstName()
	{
		// return firstName == null ? "" : WordUtils.capitalizeFully(firstName);
		return firstName;
	}

	@Override
	@Column(name = "lastname")
	public String getLastName()
	{
		// return lastName == null ? "" : WordUtils.capitalizeFully(lastName);
		return lastName;
	}

	@Override
	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	@Override
	@Column(name = "profileimageurl")
	public String getProfileImageUrl()
	{
		return profileImageUrl;
	}

	@Override
	@Column(name = "pwdchangedate")
	public LocalDateTime getPwdChangeDate()
	{
		return pwdChangeDate;
	}

	@Override
	@Column(name = "roleid")
	public String getRoleId()
	{
		return roleId;
	}

	@Override
	@Column(name = "rolename")
	public String getRoleName()
	{
		return roleName;
	}

	@Override
	@Column(name = "tokenkey")
	public String getTokenKey()
	{
		return tokenKey;
	}

	@Override
	@Column(name = "tokenkeyexpirydate")
	public LocalDateTime getTokenKeyExpiryDate()
	{
		return tokenKeyExpiryDate;
	}

	@Override
	@PrimaryKey
	@Column(name = "userid")
	public long getUserId()
	{
		return userId;
	}

	@Override
	@Column(name = "pwdchangeflag")
	public boolean isPwdChangeFlag()
	{
		return pwdChangeFlag;
	}
	
	@Column(name="departmentid")
	public long getDepartmentId()
	{
		return departmentId;
	}
	
	@Column(name="departmentname")
	public String getDepartmentName()
	{
		return departmentName;
	}

	@Override
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}

	@Override
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public void setProfileImageUrl(String profileImageUrl)
	{
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public void setPwdChangeDate(LocalDateTime pwdChangeDate)
	{
		this.pwdChangeDate = pwdChangeDate;
	}

	@Override
	public void setPwdChangeFlag(boolean pwdChangeFlag)
	{
		this.pwdChangeFlag = pwdChangeFlag;
	}

	@Override
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	@Override
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	@Override
	public void setTokenKey(String tokenKey)
	{
		this.tokenKey = tokenKey;
	}

	@Override
	public void setTokenKeyExpiryDate(LocalDateTime tokenKeyExpiryDate)
	{
		this.tokenKeyExpiryDate = tokenKeyExpiryDate;
	}

	@Override
	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}
}