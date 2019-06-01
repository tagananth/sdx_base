package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuration")
public class Configuration extends CommonCustomerBean implements IConfiguration
{
	private static final long	serialVersionUID	= -8117066273433451132L;

	protected long				configurationId;
	protected String			configurationName;
	protected String			source;
	protected String			fromId;
	protected String			fromName;
	protected String			accountSID;
	protected String			hostAddress;
	protected String			userName;
	protected String			password;
	protected String			authToken;
	protected String			portTLS;
	protected String			portSLS;
	protected String			type;
	protected String			requestUrl;
	protected String			responseUrl;

	public Configuration()
	{
		super();
	}

	public Configuration(long customerId)
	{
		super();
		this.customerId = customerId;
	}

	@Id
	@Column(name = "configurationid")
	public long getConfigurationId()
	{
		return configurationId;
	}

	@Column(name = "configurationname")
	public String getConfigurationName()
	{
		return configurationName;
	}

	@Column(name = "source")
	public String getSource()
	{
		return source;
	}

	@Column(name = "fromid")
	public String getFromId()
	{
		return fromId;
	}

	@Column(name = "fromname")
	public String getFromName()
	{
		return fromName;
	}

	@Column(name = "accountsid")
	public String getAccountSID()
	{
		return accountSID;
	}

	@Column(name = "hostaddress")
	public String getHostAddress()
	{
		return hostAddress;
	}

	@Column(name = "username")
	public String getUserName()
	{
		return userName;
	}

	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	@Column(name = "authtoken")
	public String getAuthToken()
	{
		return authToken;
	}

	@Column(name = "porttls")
	public String getPortTLS()
	{
		return portTLS;
	}

	@Column(name = "portsls")
	public String getPortSLS()
	{
		return portSLS;
	}

	@Column(name = "type")
	public String getType()
	{
		return type;
	}	
	
	@Column(name = "requesturl")
	public String getRequestUrl()
	{
		return requestUrl;
	}
	
	@Column(name = "responseurl")
	public String getResponseUrl()
	{
		return responseUrl;
	}

	// Setters

	public void setConfigurationId(long configurationId)
	{
		this.configurationId = configurationId;
	}

	public void setConfigurationName(String configurationName)
	{
		this.configurationName = configurationName;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public void setFromId(String fromId)
	{
		this.fromId = fromId;
	}

	public void setFromName(String fromName)
	{
		this.fromName = fromName;
	}

	public void setAccountSID(String accountSID)
	{
		this.accountSID = accountSID;
	}

	public void setHostAddress(String hostAddress)
	{
		this.hostAddress = hostAddress;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}

	public void setPortTLS(String portTLS)
	{
		this.portTLS = portTLS;
	}

	public void setPortSLS(String portSLS)
	{
		this.portSLS = portSLS;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setRequestUrl(String requestUrl)
	{
		this.requestUrl = requestUrl;
	}

	public void setResponseUrl(String responseUrl)
	{
		this.responseUrl = responseUrl;
	}
	
}
