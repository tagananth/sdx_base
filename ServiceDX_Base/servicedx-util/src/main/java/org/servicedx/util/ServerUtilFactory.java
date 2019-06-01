package org.servicedx.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerUtilFactory implements Serializable {

	private static final long serialVersionUID = 7653346655071987488L;
	private static ServerUtilFactory serverUtilFactory = null;
	private String serverTZ = null;
	public static final String DEVENVIRONMENT = "DEV";
	public static final String UATENVIRONMENT = "UAT";
	public static final String PORTSEPERATOR = ":";
	public static final String URLSEPERATOR = "/";
	public static final String RESETPASSWORDURL = "index/resetpassword";
	public static final String CHANGEPASSWORDURL = "index/changepassword/";
	public static final String ERRORPAGEURL = "errorpage";
	public static final String PASSWORDCHANGEDURL = "index/passwordchanged/";
	public static final String PASSWORDLINKEXPIREDURL = "index/tokenexpired/";
	
	public static enum SOMMICROSERVICE {
		SOM_ADMIN, SOM_OAUTH, SOM_SENDER, SOM_EUREKA,
	}

	@Value("${somDomainUrl:http://localhost}")
	private String somDomainUrl;
	
	@Value("${somUiServerUrl:http://localhost:4200}")
	private String somUiUrl;

	@Value("${somAdminPort:8100}")
	private String somAdminPort;

	@Value("${somAdminContext:som-admin-service}")
	private String somAdminContext;

	@Value("${somOauthPort:8090}")
	private String somOauthPort;

	@Value("${somOauthContext:som-oauth-server}")
	private String somOauthContext;

	@Value("${somSenderPort:8200}")
	private String somSenderPort;

	@Value("${somSenderContext:som-sender-service}")
	private String somSenderContext;

	@Value("${somSenderPort:8761}")
	private String somEurekaPort;

	@Value("${somSenderContext:som-eureka-server}")
	private String somEurekaContext;

	@Value("${somEnvironment:dev}")
	private String environment;

	public static ServerUtilFactory getInstance() {
		if (serverUtilFactory == null) {
			serverUtilFactory = new ServerUtilFactory();
		}
		return serverUtilFactory;
	}

	private ServerUtilFactory() {
		long milliDiff = Calendar.getInstance().get(Calendar.ZONE_OFFSET);

		for (String id : TimeZone.getAvailableIDs()) {
			if (TimeZone.getTimeZone(id).getRawOffset() == milliDiff) {
				serverTZ = id;
				break;
			}
		}
	}

	public String getTimeZone() {
		return serverTZ;
	}

	public String getDomainUrl() {
		return somDomainUrl;
	}

	public String getSomAdminUrl() {
		return getSomServiceUrl(SOMMICROSERVICE.SOM_ADMIN);
	}

	public String getSomOAuthUrl() {
		return getSomServiceUrl(SOMMICROSERVICE.SOM_OAUTH);
	}

	public String getSomSenderUrl() {
		return getSomServiceUrl(SOMMICROSERVICE.SOM_SENDER);
	}

	public String getSomEurekaUrl() {
		return getSomServiceUrl(SOMMICROSERVICE.SOM_EUREKA);
	}
	
	public String getSomUiUrl() {
		return somUiUrl;
	}

	private String getSomServiceUrl(SOMMICROSERVICE microService) {
		StringBuffer serviceUrl = new StringBuffer(somDomainUrl);
		String servicePort = null, serviceContext = null;
		switch (microService) {
		case SOM_ADMIN:
			servicePort = somAdminPort;
			serviceContext = somAdminContext;
			break;
		case SOM_OAUTH:
			servicePort = somOauthPort;
			serviceContext = somOauthContext;
			break;
		case SOM_SENDER:
			servicePort = somSenderPort;
			serviceContext = somSenderContext;
			break;
		case SOM_EUREKA:
			servicePort = somEurekaPort;
			serviceContext = somEurekaContext;
			break;
		default:
			return serviceUrl.toString();
		}
		if (DEVENVIRONMENT.equalsIgnoreCase(environment) || UATENVIRONMENT.equalsIgnoreCase(environment)) {
			serviceUrl.append(PORTSEPERATOR).append(servicePort);
		}
		return serviceUrl.append(URLSEPERATOR).append(serviceContext).append(URLSEPERATOR).toString();

	}
	
	public static String constructUrl(String ...urlArgs) {
		StringBuffer url = new StringBuffer();
		Arrays.stream(urlArgs).forEach(urlC -> url.append(urlC)); // should encode with URIencode and URLencode
		return url.toString();
	}

}
