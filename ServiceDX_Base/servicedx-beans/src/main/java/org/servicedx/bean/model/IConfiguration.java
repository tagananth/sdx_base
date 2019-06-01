package org.servicedx.bean.model;

import javax.persistence.Column;

import org.servicedx.util.ICRUDBean;

public interface IConfiguration extends ICommonCustomerBean, ICRUDBean
{

	public long getConfigurationId();

	public String getConfigurationName();

	public String getSource();;

	public String getFromId();;

	public String getFromName();;

	public String getAccountSID();

	public String getHostAddress();

	public String getUserName();

	public String getPassword();

	public String getAuthToken();

	public String getPortTLS();

	public String getPortSLS();

	public String getComments();

	public String getType();

	public String getRequestUrl();

	public String getResponseUrl();


	// Setters

	public void setConfigurationId(long configurationId);

	public void setConfigurationName(String configurationName);

	public void setSource(String source);

	public void setFromId(String fromId);

	public void setFromName(String fromName);

	public void setAccountSID(String accountsId);

	public void setHostAddress(String hostAddress);

	public void setUserName(String userName);

	public void setPassword(String password);

	public void setAuthToken(String authToken);

	public void setPortTLS(String portTLS);

	public void setPortSLS(String portSLS);

	public void setComments(String comments);

	public void setType(String type);
	
	public void setRequestUrl(String requestUrl);

	public void setResponseUrl(String responseUrl);


}