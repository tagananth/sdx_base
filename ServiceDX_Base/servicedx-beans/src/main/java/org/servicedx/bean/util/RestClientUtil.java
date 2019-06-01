package org.servicedx.bean.util;

import java.util.List;

import org.servicedx.bean.ConfigurationFormBean;
import org.servicedx.bean.GroupMemberFormBean;
import org.servicedx.bean.OTPFormBean;
import org.servicedx.bean.UserFormBean;
import org.servicedx.bean.model.Configuration;
import org.servicedx.bean.model.GroupMember;
import org.servicedx.bean.model.Users;
import org.servicedx.security.resource.IPath.EMedia;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientUtil
{

	//@Value("${client.base.url}")
	public static String	clientBaseUrl = "http://ec2-52-22-83-229.compute-1.amazonaws.com:8100/som-admin-service";

	public static String	senderBaseUrl	= "http://ec2-52-22-83-229.compute-1.amazonaws.com:8200/som-sender-service";

	public static List<Configuration> getConfigurationDetail(String token, Configuration cfBean)
	{
		List<Configuration> configList = null;
		ConfigurationFormBean form = new ConfigurationFormBean();
		form.configuration = cfBean;
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		ResponseEntity<List<Configuration>> f = null;
		if(EMedia.SMS.name().equalsIgnoreCase(cfBean.getType()))
		{
			f = new RestTemplate().exchange(senderBaseUrl + "/getActiveSMSConfiguration", HttpMethod.POST, new HttpEntity<ConfigurationFormBean>(form, headers),
					new ParameterizedTypeReference<List<Configuration>>() {
					});
		}
		else if(EMedia.Email.name().equalsIgnoreCase(cfBean.getType()))
		{
			f = new RestTemplate().exchange(senderBaseUrl + "/getActiveEmailConfiguration", HttpMethod.POST, new HttpEntity<ConfigurationFormBean>(form, headers),
					new ParameterizedTypeReference<List<Configuration>>() {
					});
		}
		if (HttpStatus.OK == f.getStatusCode())
			configList = f.getBody();
		return configList;

	}

	public static List<GroupMember> getGroupMemberDetail(String token,Long groupId)
	{
		List<GroupMember> gpMemList = null;
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		GroupMemberFormBean form = new GroupMemberFormBean();
		GroupMember groupMember			= new GroupMember();
		groupMember.setGroupId(groupId);
		form.groupMember = groupMember;
		ResponseEntity<List<GroupMember>> f = new RestTemplate().exchange(clientBaseUrl + "/getGroupMembersByGroup", HttpMethod.POST, new HttpEntity<GroupMemberFormBean>(form,headers),
				new ParameterizedTypeReference<List<GroupMember>>() {
				});
		if (HttpStatus.OK == f.getStatusCode())
			gpMemList = f.getBody();
		return gpMemList;

	}

	public static List<Users> getUserDetails(String userName)
	{
		List<Users> userList = null;
		ResponseEntity<List<Users>> f = new RestTemplate().exchange(clientBaseUrl + "/user/getUser", HttpMethod.POST, new HttpEntity<String>(userName), new ParameterizedTypeReference<List<Users>>() {
		});
		if (HttpStatus.OK == f.getStatusCode())
			userList = f.getBody();
		return userList;

	}

	public static String sendUserCreationMail(UserFormBean ufBean)
	{
		String status = null;

		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", ufBean.authToken);

		ResponseEntity<String> f = new RestTemplate().exchange(senderBaseUrl + "/createUserMail", HttpMethod.POST, new HttpEntity<UserFormBean>(ufBean, headers), new ParameterizedTypeReference<String>() {
		});
		if (HttpStatus.OK == f.getStatusCode())
			status = f.getBody();
		return status;

	}
	
	public static String sendPasswordResetMail(UserFormBean ufBean)
	{
		String status = null;

		ResponseEntity<String> f = new RestTemplate().exchange(senderBaseUrl + "/passwordResetMail", HttpMethod.POST, new HttpEntity<UserFormBean>(ufBean), new ParameterizedTypeReference<String>() {
		});
		if (HttpStatus.OK == f.getStatusCode())
			status = f.getBody();
		return status;

	}

	public static String sendPasswordResetOtp(OTPFormBean otpForm) {
		String status = null;
		ResponseEntity<String> f = new RestTemplate().exchange(senderBaseUrl + "/sendSMSForResetPassword", HttpMethod.POST, new HttpEntity<OTPFormBean>(otpForm), new ParameterizedTypeReference<String>() {
		});
		if (HttpStatus.OK == f.getStatusCode())
			status = f.getBody();
		return status;

	}

	
	public static Users getUserById(String token, UserFormBean userFormBean)
	{
		Users user = null;
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		ResponseEntity<Users> f = null;
			f = new RestTemplate().exchange(clientBaseUrl + "/getActiveUser", HttpMethod.POST, new HttpEntity<UserFormBean>(userFormBean, headers),
					new ParameterizedTypeReference<Users>() {
					});
		if (HttpStatus.OK == f.getStatusCode())
			user = f.getBody();
		return user;

	}
}
